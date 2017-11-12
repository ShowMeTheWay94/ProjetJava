package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.bastien.DAO.*;
import be.bastien.metier.*;

public class Connexion extends JFrame {
	private static final long serialVersionUID = 5245627092132909230L;
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JLabel lblMotDePasse;
	private JPasswordField passwordField;
	
	public Connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setBounds(170, 30, 50, 15);
		contentPane.add(lblPseudo);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(230, 27, 86, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(140, 70, 85, 14);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 67, 86, 20);
		contentPane.add(passwordField);
		
		//Connexion
		JButton Connect = new JButton("Connexion");
		Connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciation du dao et du POJO
				DAOPersonne daoPersonne = new DAOPersonne(ProjetConnection.getInstance());
				DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
				DAOResponsable daoResponsable = new DAOResponsable(ProjetConnection.getInstance());
				DAOTresorier daoTresorier = new DAOTresorier(ProjetConnection.getInstance());
				Personne personne = new Personne();
				
				personne.setLogin(txtPseudo.getText());
				personne.setPassword(String.valueOf(passwordField.getPassword()));
				personne = daoPersonne.find(personne);
				if(daoMembre.find(personne)) {
					dispose();
					AcceuilMembre acceuilMembre = new AcceuilMembre();
					acceuilMembre.setPersonne(personne);
					acceuilMembre.setTitle("Acceuil Membre");
					acceuilMembre.setVisible(true);
				}
				else if(daoResponsable.find(personne)) {
					dispose();
					AcceuilResponsable acceuilResponsable = new AcceuilResponsable();
					acceuilResponsable.setPersonne(personne);
					acceuilResponsable.setTitle("Acceuil Responsable");
					acceuilResponsable.setVisible(true);
				}
				else if(daoTresorier.find(personne)) {
					dispose();
					AcceuilTresorier acceuilTresorier = new AcceuilTresorier();
					acceuilTresorier.setPersonne(personne);
					acceuilTresorier.setTitle("Acceuil trésorier");
					acceuilTresorier.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Connexion ratée");
				}
			}
		});
		Connect.setBounds(120, 110, 100, 30);
		contentPane.add(Connect);
	
	JButton Retour = new JButton("Retour");
	Retour.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			Acceuil acceuil = new Acceuil();
			acceuil.setTitle("Acceuil");
			acceuil.setVisible(true);
		}
	});
	Retour.setBounds(230, 110, 100, 30);
	contentPane.add(Retour);
	}
}
