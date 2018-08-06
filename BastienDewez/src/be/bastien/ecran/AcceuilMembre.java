package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Membre;

public class AcceuilMembre extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	
	public AcceuilMembre(Membre membre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Bouton inscription cat�gorie
		JButton btnInscription = new JButton("Inscription � une cat�gorie");
		btnInscription.setBounds(90, 20, 250, 30);
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage inscription cat�gorie
				dispose();
				InscriptionCategorie inscriptionCategorie = new InscriptionCategorie(membre);
				inscriptionCategorie.setTitle("Inscription cat�gorie");
				inscriptionCategorie.setVisible(true);
			}
		});
		contentPane.add(btnInscription);
		
		//Bouton g�rer les disponibilit�s
		JButton btnDisponibilite = new JButton("G�rer les disponibilit�s");
		btnDisponibilite.setBounds(90, 60, 250, 30);
		btnDisponibilite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage g�rer les disponibilit�s
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(membre);
				gererDisponibilites.setTitle("G�rer les disponibilit�s");
				gererDisponibilites.setVisible(true);
			}
		});
		contentPane.add(btnDisponibilite);
		
		//Bouton afficher les forfaits
		JButton btnForfait = new JButton("Afficher les forfaits");
		btnForfait.setBounds(90, 100, 250, 30);
		btnForfait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage afficher les forfaits
				dispose();
				AfficherForfait afficherForfait = new AfficherForfait(membre);
				afficherForfait.setTitle("Afficher forfait");
				afficherForfait.setVisible(true);
			}
		});
		contentPane.add(btnForfait);
		
		//Bouton afficher les suppl�ments
		JButton btnSupplement = new JButton("Afficher les suppl�ments");
		btnSupplement.setBounds(90, 140, 250, 30);
		btnSupplement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage afficher les suppl�ments
				dispose();
				AfficherSupplement afficherSupplement = new AfficherSupplement(membre);
				afficherSupplement.setTitle("Afficher suppl�ment");
				afficherSupplement.setVisible(true);
			}
		});
		contentPane.add(btnSupplement);
		
		if(membre.getCotisation() != 0) {
			//Bouton payer cotisation
			JButton btnCotisation = new JButton("Payer cotisation");
			btnCotisation.setBounds(90, 180, 250, 30);
			btnCotisation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					//Instanciation du daoMembre
					DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
					
					//Instanciation et initialisation des variables du membre
					membre.setCotisation(0);
					membre.setStatutCotisation("Pay�");
					
					//Mise � jour du membre
					if(daoMembre.update(membre)) {
						JOptionPane.showMessageDialog(null, "Cotisation pay�e");
						btnCotisation.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Paiement cotisation rat�e");
					}
				}
			});
			contentPane.add(btnCotisation);
		}
		
		//Bouton retour
		JButton Retour = new JButton("Deconnexion");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage accueil
				dispose();
				Acceuil acceuil = new Acceuil();
				acceuil.setTitle("Accueil");
				acceuil.setVisible(true);
			}
		});
		Retour.setBounds(304, 220, 120, 30);
		contentPane.add(Retour);
	}
}
