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
import be.bastien.POJO.*;

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
				DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
				POJOMembre pojoMembre = new POJOMembre();
				
				pojoMembre.setLogin(txtPseudo.getText());
				pojoMembre.setPassword(String.valueOf(passwordField.getPassword()));
				if(daoMembre.find(pojoMembre)) {
					JOptionPane.showMessageDialog(null, "Connexion réussie");
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
			acceuil.setTitle("Connexion");
			acceuil.setVisible(true);
		}
	});
	Retour.setBounds(230, 110, 100, 30);
	contentPane.add(Retour);
	}
}
