package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AcceuilMembre extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	
	public AcceuilMembre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnInscription = new JButton("Inscription � une cat�gorie");
		btnInscription.setBounds(90, 20, 250, 30);
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnInscription);
		
		JButton btnDisponibilite = new JButton("Ajouter une disponibilit�");
		btnDisponibilite.setBounds(90, 60, 250, 30);
		btnDisponibilite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnDisponibilite);
		
		JButton btnForfait = new JButton("Afficher les forfaits");
		btnForfait.setBounds(90, 100, 250, 30);
		btnForfait.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnForfait);
		
		JButton btnSupplement = new JButton("Afficher les suppl�ments");
		btnSupplement.setBounds(90, 140, 250, 30);
		btnSupplement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnSupplement);
		
		JButton btnCotisation = new JButton("Payer cotisation");
		btnCotisation.setBounds(90, 180, 250, 30);
		btnCotisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnCotisation);
		
		JButton Retour = new JButton("Deconnexion");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Connexion connexion = new Connexion();
				connexion.setTitle("Connexion");
				connexion.setVisible(true);
			}
		});
		Retour.setBounds(304, 220, 120, 30);
		contentPane.add(Retour);
	}
}
