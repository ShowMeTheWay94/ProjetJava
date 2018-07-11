package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.bastien.metier.Personne;

public class AcceuilTresorier extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	
	public AcceuilTresorier(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnRemboursement = new JButton("Remboursement des chauffeurs");
		btnRemboursement.setBounds(100, 40, 250, 30);
		btnRemboursement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				dispose();
				RemboursementChauffeur remboursementChauffeur = new RemboursementChauffeur(personne);
				remboursementChauffeur.setTitle("Remboursement chauffeur");
				remboursementChauffeur.setVisible(true);
			}
		});
		contentPane.add(btnRemboursement);
		
		JButton btnCotisation = new JButton("Cotisations à payer");
		btnCotisation.setBounds(100, 90, 250, 30);
		btnCotisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				dispose();
				PaiementCotisation paiementCotisation = new PaiementCotisation(personne);
				paiementCotisation.setTitle("Cotisations à payer");
				paiementCotisation.setVisible(true);
			}
		});
		contentPane.add(btnCotisation);
		
		JButton Retour = new JButton("Deconnexion");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Acceuil acceuil = new Acceuil();
				acceuil.setTitle("Acceuil");
				acceuil.setVisible(true);
			}
		});
		Retour.setBounds(304, 160, 120, 30);
		contentPane.add(Retour);
	}
}
