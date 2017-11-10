package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AcceuilTresorier extends JFrame {
	private static final long serialVersionUID = -3207631333749439129L;
	private JPanel contentPane;
	
	public AcceuilTresorier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnRemboursement = new JButton("Remboursement des chauffeurs");
		btnRemboursement.setBounds(100, 40, 250, 30);
		btnRemboursement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnRemboursement);
		
		JButton btnCotisation = new JButton("V�rifier les paiements des cotisations");
		btnCotisation.setBounds(100, 90, 250, 30);
		btnCotisation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				
			}
		});
		contentPane.add(btnCotisation);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Connexion connexion = new Connexion();
				connexion.setTitle("Connexion");
				connexion.setVisible(true);
			}
		});
		Retour.setBounds(324, 170, 100, 30);
		contentPane.add(Retour);
	}
}