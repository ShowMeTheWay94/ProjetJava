package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.metier.Personne;

public class CalculerForfait extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public CalculerForfait(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblBalade = new JLabel("Nom Balade - Lieu - Date - Forfait");
		lblBalade.setBounds(90,20,280,20);
		contentPane.add(lblBalade);
		
		JComboBox<String> cmBoxBalade = new JComboBox<String>();
		cmBoxBalade.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxBalade);
		
		JButton Forfait = new JButton("Calculer forfait");
		Forfait.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		Forfait.setBounds(114, 114, 120, 30);
		contentPane.add(Forfait);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilResponsable acceuilResponsable = new AcceuilResponsable(personne);
				acceuilResponsable.setTitle("Acceuil Responsable");
				acceuilResponsable.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
}
