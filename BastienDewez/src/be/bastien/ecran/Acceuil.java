package be.bastien.ecran;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Acceuil extends JFrame {
	private static final long serialVersionUID = -3593788473037822996L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Affichage page accueil
					Acceuil acceuil = new Acceuil();
					acceuil.setTitle("Accueil");
					acceuil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Acceuil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Bouton connexion
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(120, 115, 100, 30);
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Connexion connexion = new Connexion();
				connexion.setTitle("Connexion");
				connexion.setVisible(true);
			}
		});
		contentPane.add(btnConnexion);
		
		//Bouton inscription
		JButton btnInscription = new JButton("Inscription");
		btnInscription.setBounds(230, 115, 100, 30);
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				dispose();
				Inscription inscription = new Inscription();
				inscription.setTitle("Inscription");
				inscription.setVisible(true);
			}
		});
		contentPane.add(btnInscription);
		
		//Bouton quitter
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(324, 220, 100, 30);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnQuitter);
	}
}
