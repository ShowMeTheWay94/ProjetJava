package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.DAO.DAOCategorie;
import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Categorie;
import be.bastien.metier.Membre;

public class AfficherSupplement extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public AfficherSupplement(Membre membre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblSupplement = new JLabel("Nom Categorie - Supplément");
		lblSupplement.setBounds(110,20,280,20);
		contentPane.add(lblSupplement);
		
		//Initialisation de la comboBox avec des catégories
		JComboBox<Categorie> cmBoxSupplement = new JComboBox<Categorie>();
		DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
		DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
		List<Categorie> listeCategorieMembre = daoMembre.findCategorie(membre);
		List<Categorie> listeCategorie = daoCategorie.find();
		for(int i = 0;i < listeCategorieMembre.size();i++) {
			for(int j = 0;j < listeCategorie.size();j++) {
				if(listeCategorieMembre.get(i).getIdCategorie() == listeCategorie.get(j).getIdCategorie()) {
					if(listeCategorieMembre.get(i).getSupplement() != 0) {
						Categorie categorie = new Categorie();
						categorie.setIdCategorie(listeCategorieMembre.get(i).getIdCategorie());
						categorie.setNomCategorie(listeCategorie.get(j).getNomCategorie());
						categorie.setSupplement(listeCategorieMembre.get(i).getSupplement());
						cmBoxSupplement.addItem(categorie);
					}
				}
			}
		}
		cmBoxSupplement.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxSupplement);
		
		JButton Payer = new JButton("Payer");
		Payer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation du daoCategorie
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				
				//Instanciation de la catégorie et initialisation du supplément
				Categorie categorie = (Categorie)cmBoxSupplement.getSelectedItem();
				categorie.setSupplement(0);
				
				//Mise à jour de la catégorie
				daoCategorie.update(categorie);
				
				dispose();
				AfficherSupplement afficherSupplement = new AfficherSupplement(membre);
				afficherSupplement.setTitle("Afficher supplément");
				afficherSupplement.setVisible(true);
			}
		});
		Payer.setBounds(114, 114, 120, 30);
		contentPane.add(Payer);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre(membre);
				acceuilMembre.setTitle("Accueil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
}
