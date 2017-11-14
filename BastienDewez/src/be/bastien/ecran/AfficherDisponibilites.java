package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.metier.Personne;

public class AfficherDisponibilites extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	public Personne personne;
	
	public AfficherDisponibilites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblDisponibilites = new JLabel("Nom Balade - Place Membre - Place V�lo");
		lblDisponibilites.setBounds(70,20,280,20);
		contentPane.add(lblDisponibilites);
		
		JComboBox<String> cmBoxDisponibilites = new JComboBox<String>();
		cmBoxDisponibilites.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxDisponibilites);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilResponsable acceuilResponsable = new AcceuilResponsable();
				acceuilResponsable.setPersonne(personne);
				acceuilResponsable.setTitle("Acceuil Responsable");
				acceuilResponsable.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
	
	public Personne getPersonne(){
		return personne;
	}
	
	public void setPersonne(Personne personne){
		this.personne = personne;
	}
}
