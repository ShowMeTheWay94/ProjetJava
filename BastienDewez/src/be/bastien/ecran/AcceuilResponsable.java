package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.bastien.metier.Personne;

public class AcceuilResponsable extends JFrame {
	private static final long serialVersionUID = 2341718848245518222L;
	private JPanel contentPane;
	
	public AcceuilResponsable(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Bouton afficher le calendrier des balades
		JButton btnBalade = new JButton("Afficher le calendrier des balades");
		btnBalade.setBounds(100, 40, 250, 30);
		btnBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage afficher les balades
				dispose();
				AfficherBalade afficherBalade = new AfficherBalade(personne);
				afficherBalade.setTitle("Afficher les balades");
				afficherBalade.setVisible(true);
			}
		});
		contentPane.add(btnBalade);
		
		//Bouton vérifier disponiblités
		JButton btnDisponibilites = new JButton("Vérifier les disponibilités");
		btnDisponibilites.setBounds(100, 90, 250, 30);
		btnDisponibilites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//Affichage afficher les disponibilités
				dispose();
				AfficherDisponibilites afficherDisponibilites = new AfficherDisponibilites(personne);
				afficherDisponibilites.setTitle("Afficher les disponibilités");
				afficherDisponibilites.setVisible(true);
			}
		});
		contentPane.add(btnDisponibilites);
		
		//Bouton calculer le forfait
		JButton btnForfait = new JButton("Calculer le forfait pour une balade");
		btnForfait.setBounds(100,140,250,30);
		btnForfait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Affichage calculer forfait
				dispose();
				CalculerForfait calculerForfait = new CalculerForfait(personne);
				calculerForfait.setTitle("Calculer forfait");
				calculerForfait.setVisible(true);
			}
		});
		contentPane.add(btnForfait);
		
		//Bouton deconnexion
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
