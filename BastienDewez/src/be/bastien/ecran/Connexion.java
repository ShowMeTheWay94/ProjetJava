package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	private boolean trouve = false;
	
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
				//Instanciation des daoPersonne, daoMembre, daoResponsable et daoTresorier
				DAOPersonne daoPersonne = new DAOPersonne(ProjetConnection.getInstance());
				DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
				DAOResponsable daoResponsable = new DAOResponsable(ProjetConnection.getInstance());
				DAOTresorier daoTresorier = new DAOTresorier(ProjetConnection.getInstance());
				
				//Vérification login et mot de passe
				List<Personne> listPersonne = daoPersonne.find();
				for(int i = 0;i < listPersonne.size();i++) {
					if(listPersonne.get(i).getLogin().equals(txtPseudo.getText()) && listPersonne.get(i).getPassword().equals(String.valueOf(passwordField.getPassword()))) {
						//Vérification si l'utilisateur est un membre
						List<Membre> listMembre = daoMembre.find();
						for(int j = 0;j < listMembre.size(); j++) {
							if(listPersonne.get(i).getIdPersonne() == listMembre.get(j).getIdPersonne()) {
								trouve = true;
								dispose();
								AcceuilMembre acceuilMembre = new AcceuilMembre(listPersonne.get(i));
								acceuilMembre.setTitle("Acceuil Membre");
								acceuilMembre.setVisible(true);
							}
						}
						
						//Vérification si l'utilisateur est un responsable
						List<Responsable> listResponsable = daoResponsable.find();
						for(int j = 0;j < listResponsable.size(); j++) {
							if(listPersonne.get(i).getIdPersonne() == listResponsable.get(j).getIdPersonne()) {
								trouve = true;
								dispose();
								AcceuilResponsable acceuilResponsable = new AcceuilResponsable(listPersonne.get(i));
								acceuilResponsable.setTitle("Acceuil Responsable");
								acceuilResponsable.setVisible(true);
							}
						}
						
						//Vérification si l'utilisateur est un trésorier
						List<Tresorier> listTresorier = daoTresorier.find();
						for(int j = 0;j < listTresorier.size(); j++) {
							if(listPersonne.get(i).getIdPersonne() == listTresorier.get(j).getIdPersonne()) {
								trouve = true;
								dispose();
								AcceuilTresorier acceuilTresorier = new AcceuilTresorier(listPersonne.get(i));
								acceuilTresorier.setTitle("Acceuil trésorier");
								acceuilTresorier.setVisible(true);
							}
						}
					}
				}
				if(!trouve) {
					JOptionPane.showMessageDialog(null,"Pas d'utilisateur existant avec ces identifiants");
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
