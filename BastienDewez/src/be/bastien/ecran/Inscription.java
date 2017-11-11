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

public class Inscription extends JFrame {
	private static final long serialVersionUID = -6610007716347006771L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtPseudo;
	private JPasswordField Mdp;
	private JPasswordField MdpConfirm;
	private JTextField txtCategorie;

	public Inscription() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 350);
	contentPane = new JPanel();
	contentPane.setLayout(null);
	setContentPane(contentPane);
	
	JLabel lblNom = new JLabel("Nom :");
	lblNom.setBounds(80, 24, 50, 14);
	contentPane.add(lblNom);
	
	txtNom = new JTextField();
	txtNom.setBounds(230, 21, 100, 20);
	contentPane.add(txtNom);
	
	JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
	lblPrnom.setBounds(80, 64, 60, 14);
	contentPane.add(lblPrnom);
	
	txtPrenom = new JTextField();
	txtPrenom.setBounds(230, 61, 100, 20);
	contentPane.add(txtPrenom);
	
	
	JLabel lblPseudo = new JLabel("Pseudo :");
	lblPseudo.setBounds(80, 104, 60, 14);
	contentPane.add(lblPseudo);
	
	txtPseudo = new JTextField();
	txtPseudo.setBounds(230, 101, 100, 20);
	contentPane.add(txtPseudo);
	
	JLabel lblMotDePasse = new JLabel("Mot de passe :");
	lblMotDePasse.setBounds(80, 144, 120, 14);
	contentPane.add(lblMotDePasse);
	
	Mdp = new JPasswordField();
	Mdp.setBounds(230, 141, 100, 20);
	contentPane.add(Mdp);
	
	JLabel lblMotDePasseConfirm = new JLabel("Confirmer mot de passe :");
	lblMotDePasseConfirm.setBounds(80, 184, 150, 14);
	contentPane.add(lblMotDePasseConfirm);
	
	MdpConfirm = new JPasswordField();
	MdpConfirm.setBounds(230, 181, 100, 20);
	contentPane.add(MdpConfirm);
	
	JLabel lblCategorie = new JLabel("Cat�gorie :");
	lblCategorie.setBounds(80,224,150,14);
	contentPane.add(lblCategorie);
	
	txtCategorie = new JTextField();
	txtCategorie.setBounds(230, 221, 100, 20);
	contentPane.add(txtCategorie);
	
	JButton btnInscription = new JButton("Inscription");
	btnInscription.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DAOPersonne daoPersonne = new DAOPersonne(ProjetConnection.getInstance());
			DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
			DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
			
			Categorie categorie = daoCategorie.find(txtCategorie.getText());
			categorie.setSupplement(0);
			
			Personne personne = new Personne();
			personne.setNom(txtNom.getText());
			personne.setPrenom(txtPrenom.getText());
			personne.setLogin(txtPseudo.getText());
			personne.setPassword(String.valueOf(Mdp.getPassword()));
			
			Membre membre = new Membre();
			membre.setCotisation(20);
			membre.setStatutCotisation("A payer");
			
			if(String.valueOf(Mdp.getPassword()).equals(String.valueOf(MdpConfirm.getPassword()))) {
				if(daoPersonne.create(personne)) {
					membre.setIdPersonne(personne.getIdPersonne());
					if(daoMembre.create(membre)) {
						if(daoMembre.addCategorie(membre,categorie)) {
							int nbr = categorie.getNbrMembres();
							categorie.setNbrMembres(++nbr);
							daoCategorie.update(categorie);
							dispose();
							Acceuil acceuil = new Acceuil();
							acceuil.setTitle("Acceuil");
							acceuil.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Ajout de la cat�gorie rat�e");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Inscription rat�e");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas");;
				}
			}
		}
	});
	btnInscription.setBounds(10, 270, 100, 30);
	contentPane.add(btnInscription);
	
	JButton btnRetour = new JButton("Retour");
	btnRetour.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Acceuil acceuil = new Acceuil();
			acceuil.setTitle("Acceuil");
			acceuil.setVisible(true);
		}
	});
	btnRetour.setBounds(324, 270, 100, 30);
	contentPane.add(btnRetour);
	}
}