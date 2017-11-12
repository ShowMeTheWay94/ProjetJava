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
	public Personne personne;
	
	public AcceuilResponsable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnBalade = new JButton("Afficher le calendrier des balades");
		btnBalade.setBounds(100, 40, 250, 30);
		btnBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnBalade);
		
		JButton btnDisponibilites = new JButton("V�rifier les disponibilit�s");
		btnDisponibilites.setBounds(100, 90, 250, 30);
		btnDisponibilites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnDisponibilites);
		
		JButton btnForfait = new JButton("Calculer le forfait pour une balade");
		btnForfait.setBounds(100,140,250,30);
		btnForfait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton Retour = new JButton("Deconnexion");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Connexion connexion = new Connexion();
				connexion.setTitle("Connexion");
				connexion.setVisible(true);
			}
		});
		Retour.setBounds(304, 170, 120, 30);
		contentPane.add(Retour);
	}
	
	public Personne getPersonne(){
		return personne;
	}
	
	public void setPersonne(Personne personne){
		this.personne = personne;
	}
}