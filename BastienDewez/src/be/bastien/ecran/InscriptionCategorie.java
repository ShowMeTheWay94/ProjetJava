package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.bastien.DAO.DAOCategorie;
import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Categorie;
import be.bastien.metier.Membre;
import be.bastien.metier.Personne;

public class InscriptionCategorie extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	private JTextField txtCategorie;
	public Personne personne;
	
	public InscriptionCategorie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCategorie = new JLabel("Cat�gorie :");
		lblCategorie.setBounds(110,24,100,14);
		contentPane.add(lblCategorie);
		
		txtCategorie = new JTextField();
		txtCategorie.setBounds(190, 21, 100, 20);
		contentPane.add(txtCategorie);
		
		JButton Inscription = new JButton("Inscription");
		Inscription.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				
				Categorie categorie = daoCategorie.find(txtCategorie.getText());
				categorie.setSupplement(5);
				
				Membre membre = new Membre();
				membre.setIdPersonne(personne.getIdPersonne());
				
				if(daoMembre.addCategorie(membre,categorie)) {
					int nbr = categorie.getNbrMembres();
					categorie.setNbrMembres(++nbr);
					daoCategorie.update(categorie);
					dispose();
					AcceuilMembre acceuilMembre = new AcceuilMembre();
					acceuilMembre.setPersonne(personne);
					acceuilMembre.setTitle("Acceuil Membre");
					acceuilMembre.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ajout de la cat�gorie rat�e");
				}
			}
		});
		Inscription.setBounds(20, 64, 120, 30);
		contentPane.add(Inscription);
		
		JButton Retour = new JButton("Annuler");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre();
				acceuilMembre.setPersonne(personne);
				acceuilMembre.setTitle("Acceuil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(294, 64, 120, 30);
		contentPane.add(Retour);
	}
	
	public Personne getPersonne(){
		return personne;
	}
	
	public void setPersonne(Personne personne){
		this.personne = personne;
	}
}