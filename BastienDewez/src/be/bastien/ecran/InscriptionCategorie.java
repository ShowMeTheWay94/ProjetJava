package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.bastien.DAO.DAOCategorie;
import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Categorie;
import be.bastien.metier.Membre;
import be.bastien.metier.Personne;

public class InscriptionCategorie extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
	DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
	
	public InscriptionCategorie(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCategorie = new JLabel("Catégorie :");
		lblCategorie.setBounds(110,24,100,14);
		contentPane.add(lblCategorie);
		
		JComboBox<String> comboCategorie = new JComboBox<String>();
		List<Categorie> listeCategorie = daoCategorie.find();
		List<Integer> listeCategorieMembre = daoMembre.findCategorie(personne);
		for(int i = 0; i < listeCategorieMembre.size();i++) {
			for(int j = 0;j < listeCategorie.size();j++) {
				if(listeCategorieMembre.get(i) == listeCategorie.get(j).getIdCategorie()) {
					listeCategorie.remove(j);
				}
			}
		}
		for(int i = 0;i < listeCategorie.size();i++) {
			comboCategorie.addItem(listeCategorie.get(i).getNomCategorie());
		}
		comboCategorie.setBounds(190, 21, 100, 20);
		contentPane.add(comboCategorie);
		
		JButton Inscription = new JButton("Inscription");
		Inscription.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation des daoMembre et daoCategorie
				DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				
				//Instanciation et initialisation des variables de la catégorie
				Categorie categorie = new Categorie();
				for(int i = 0;i < listeCategorie.size();i++) {
					if(listeCategorie.get(i).getNomCategorie() == comboCategorie.getSelectedItem().toString()) {
						categorie = listeCategorie.get(i);
					}
				}
				categorie.setSupplement(5);
				
				//Instanciation et initialisation des variables du membre
				Membre membre = new Membre();
				membre.setIdPersonne(personne.getIdPersonne());
				
				//Vérification si les champs sont vides et ajout dans la table membre_categorie
				if(daoMembre.addCategorie(membre,categorie)) {
					//Récupération du nombre de membre de la catégorie, incrémentation du nombre et mise à jour de la catégorie
					int nbr = categorie.getNbrMembres();
					categorie.setNbrMembres(++nbr);
					daoCategorie.update(categorie);
						
					dispose();
					AcceuilMembre acceuilMembre = new AcceuilMembre(personne);
					acceuilMembre.setTitle("Acceuil Membre");
					acceuilMembre.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ajout de la catégorie ratée");
				}
			}
		});
		Inscription.setBounds(20, 64, 120, 30);
		contentPane.add(Inscription);
		
		JButton Retour = new JButton("Annuler");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre(personne);
				acceuilMembre.setTitle("Acceuil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(294, 64, 120, 30);
		contentPane.add(Retour);
	}
}
