package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.bastien.DAO.DAOBalade;
import be.bastien.DAO.DAOCategorie;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Balade;
import be.bastien.metier.Categorie;
import be.bastien.metier.Personne;

public class AjouterBalade extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public AjouterBalade (Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(110, 14, 100, 14);
		contentPane.add(lblNom);
		
		JTextField txtNom = new JTextField();
		txtNom.setBounds(180, 11, 100, 20);
		contentPane.add(txtNom);
		
		JLabel lblLieu = new JLabel("Lieu :");
		lblLieu.setBounds(110, 74, 140, 14);
		contentPane.add(lblLieu);
		
		JTextField txtLieu = new JTextField();
		txtLieu.setBounds(180, 71, 100, 20);
		contentPane.add(txtLieu);
		
		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setBounds(110, 134, 120, 14);
		contentPane.add(lblCategorie);
		
		JTextField txtCategorie = new JTextField();
		txtCategorie.setBounds(180, 131, 100, 20);
		contentPane.add(txtCategorie);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciation des daoBalade et daoCategorie
				DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				
				//Instanciation de la catégorie
				Categorie categorie = daoCategorie.find(txtCategorie.getText());
				
				//Instanciation et initialisation des variables du membre
				Balade balade = new Balade();
				balade.setNomBalade(txtNom.getText());
				balade.setLieuDepart(txtLieu.getText());
				balade.setCategorie(categorie);
				
				//Vérification si les champs sont vides et ajout de la balade
				if(!txtNom.getText().equals("") && !txtLieu.getText().equals("") && !txtCategorie.getText().equals("")) {
					if(daoBalade.create(balade)) {
						dispose();
						AfficherBalade afficherBalade = new AfficherBalade(personne);
						afficherBalade.setTitle("Afficher les balades");
						afficherBalade.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Ajout raté");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vides");
				}
			}
		});
		btnAjouter.setBounds(10, 164, 100, 30);
		contentPane.add(btnAjouter);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AfficherBalade afficherBalade = new AfficherBalade(personne);
				afficherBalade.setTitle("Afficher les balades");
				afficherBalade.setVisible(true);
			}
		});
		Retour.setBounds(244, 164, 120, 30);
		contentPane.add(Retour);
	}
}
