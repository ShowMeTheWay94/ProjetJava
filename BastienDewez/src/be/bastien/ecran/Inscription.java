package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox<String> comboCategorie;
	
	//Instanciation des daoPersonne, daoMembre et daoCategorie
	DAOPersonne daoPersonne = new DAOPersonne(ProjetConnection.getInstance());
	DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
	DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());

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
	
	JLabel lblPrnom = new JLabel("Prenom :");
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
	
	JLabel lblCategorie = new JLabel("Catégorie :");
	lblCategorie.setBounds(80,224,150,14);
	contentPane.add(lblCategorie);
	
	comboCategorie = new JComboBox<String>();
	List<Categorie> listeCategorie = daoCategorie.find();
	for(int i = 0;i < listeCategorie.size();i++) {
		comboCategorie.addItem(listeCategorie.get(i).getNomCategorie());
	}
	comboCategorie.setBounds(230, 221, 100, 20);
	contentPane.add(comboCategorie);
	
	JButton btnInscription = new JButton("Inscription");
	btnInscription.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			Categorie categorie = new Categorie();
			//Instanciation et initialisation des variables de la catégorie
			for(int i = 0;i < listeCategorie.size();i++) {
				if(listeCategorie.get(i).getNomCategorie() == comboCategorie.getSelectedItem().toString()) {
					categorie = listeCategorie.get(i);
				}
			}
			categorie.setSupplement(0);
			
			//Instanciation et initialisation des variables d'une personne
			Personne personne = new Personne();
			personne.setNom(txtNom.getText());
			personne.setPrenom(txtPrenom.getText());
			personne.setLogin(txtPseudo.getText());
			personne.setPassword(String.valueOf(Mdp.getPassword()));
			
			//Instanciation et initialisation des variables du membre
			Membre membre = new Membre();
			membre.setCotisation(20);
			membre.setStatutCotisation("A payer");
			
			//Vérification si les champs sont vides, vérification des mots de passe,création de la personne et du membre et ajout dans la table membre_categorie
			if(!txtPseudo.getText().equals("") && !txtPrenom.getText().equals("") && !txtNom.getText().equals("") && !(Mdp.getPassword().length == 0) && !(MdpConfirm.getPassword().length ==0)) {
				if(String.valueOf(Mdp.getPassword()).equals(String.valueOf(MdpConfirm.getPassword()))) {
					if(daoPersonne.create(personne)) {
						membre.setIdPersonne(personne.getIdPersonne());
						if(daoMembre.create(membre)) {
							if(daoMembre.addCategorie(membre,categorie)) {
								//Récupération du nombre de membre de la catégorie, incrémentation du nombre et mise à jour de la catégorie
								int nbr = categorie.getNbrMembres();
								categorie.setNbrMembres(++nbr);
								daoCategorie.update(categorie);
								
								dispose();
								Acceuil acceuil = new Acceuil();
								acceuil.setTitle("Acceuil");
								acceuil.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(null, "Ajout de la catégorie ratée");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Inscription ratée");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Inscription ratée");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Les mots de passe ne correspondent pas");;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vides");
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