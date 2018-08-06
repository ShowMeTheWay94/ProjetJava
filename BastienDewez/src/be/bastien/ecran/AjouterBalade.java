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
	DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
	
	public AjouterBalade (Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(80, 14, 100, 14);
		contentPane.add(lblNom);
		
		JTextField txtNom = new JTextField();
		txtNom.setBounds(190, 11, 100, 20);
		contentPane.add(txtNom);
		
		JLabel lblLieu = new JLabel("Lieu :");
		lblLieu.setBounds(80, 54, 140, 14);
		contentPane.add(lblLieu);
		
		JTextField txtLieu = new JTextField();
		txtLieu.setBounds(190, 51, 100, 20);
		contentPane.add(txtLieu);
		
		JLabel lblDate = new JLabel("Date (jj-mm-yyyy) :");
		lblDate.setBounds(80, 94, 140, 14);
		contentPane.add(lblDate);
		
		JTextField txtDate = new JTextField();
		txtDate.setBounds(190, 91, 100, 20);
		contentPane.add(txtDate);
		
		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setBounds(80, 134, 120, 14);
		contentPane.add(lblCategorie);
		
		//Initialisation combo catégorie
		JComboBox<String> comboCategorie = new JComboBox<String>();
		List<Categorie> listeCategorie = daoCategorie.find();
		for(int i = 0;i < listeCategorie.size();i++) {
			comboCategorie.addItem(listeCategorie.get(i).getNomCategorie());
		}
		comboCategorie.setBounds(190, 131, 100, 20);
		contentPane.add(comboCategorie);
		
		//Bouton ajouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciation des daoBalade et daoCategorie
				DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				
				//Instanciation de la catégorie
				List<Categorie> listeCategorie = daoCategorie.find();
				for(int i = 0;i < listeCategorie.size();i++) {
					if(comboCategorie.getSelectedItem() == listeCategorie.get(i).getNomCategorie()) {
						Categorie categorie = new Categorie();
						categorie.setIdCategorie(listeCategorie.get(i).getIdCategorie());
						categorie.setNbrMembres(listeCategorie.get(i).getNbrMembres());
						categorie.setNomCategorie(listeCategorie.get(i).getNomCategorie());
						categorie.setSupplement(listeCategorie.get(i).getSupplement());
						
						//Vérification si les champs sont vides et ajout de la balade
						if(!txtNom.getText().equals("") && !txtLieu.getText().equals("") && !txtDate.getText().equals("") && !comboCategorie.getSelectedItem().equals("")) {
							//Instanciation et initialisation des variables du membre
							Balade balade = new Balade();
							balade.setNomBalade(txtNom.getText());
							balade.setLieuDepart(txtLieu.getText());
							balade.setDateBalade(txtDate.getText());
							balade.setCategorie(categorie);
							
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
				}
			}
		});
		btnAjouter.setBounds(10, 164, 100, 30);
		contentPane.add(btnAjouter);
		
		//Bouton retour
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage afficher les balades
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
