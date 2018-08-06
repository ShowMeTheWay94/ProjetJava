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
import be.bastien.DAO.DAOVehicule;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Balade;
import be.bastien.metier.Membre;
import be.bastien.metier.Vehicule;

public class AjouterDisponibilites extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
	
	public AjouterDisponibilites(Membre membre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblBalade = new JLabel("Balade :");
		lblBalade.setBounds(70,24,100,14);
		contentPane.add(lblBalade);
		
		//Initialisation combo balade
		JComboBox<String> comboBalade = new JComboBox<String>();
		List<Balade> listeBalade = daoBalade.find();
		for(int i = 0; i < listeBalade.size();i++) {
			comboBalade.addItem(listeBalade.get(i).getNomBalade());
		}
		comboBalade.setBounds(220, 21, 120, 20);
		contentPane.add(comboBalade);
		
		JLabel lblImmatriculation = new JLabel("Immatriculation :");
		lblImmatriculation.setBounds(70, 54, 100, 14);
		contentPane.add(lblImmatriculation);
		
		JTextField txtImmatriculation = new JTextField();
		txtImmatriculation.setBounds(220, 51, 120, 20);
		contentPane.add(txtImmatriculation);
		
		JLabel lblPlaceMembre = new JLabel("Nombre place membre :");
		lblPlaceMembre.setBounds(70, 84, 140, 14);
		contentPane.add(lblPlaceMembre);
		
		JTextField txtPlaceMembre = new JTextField();
		txtPlaceMembre.setBounds(220, 81, 120, 20);
		contentPane.add(txtPlaceMembre);
		
		JLabel lblPlaceVelo = new JLabel("Nombre place vélo :");
		lblPlaceVelo.setBounds(70, 114, 120, 14);
		contentPane.add(lblPlaceVelo);
		
		JTextField txtPlaceVelo = new JTextField();
		txtPlaceVelo.setBounds(220, 111, 120, 20);
		contentPane.add(txtPlaceVelo);
		
		//Bouton ajouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciation du daoVehicule et daoBalade
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
				
				//Instanciation et initialisation des variables du vehicule
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(txtImmatriculation.getText());
				vehicule.setPlaceLibreMembre(Integer.parseInt(txtPlaceMembre.getText()));
				vehicule.setPlaceLibreVelo(Integer.parseInt(txtPlaceVelo.getText()));
				vehicule.setConducteur(membre);
				
				//Instanciation et initialisation des variables de la balade
				Balade balade = new Balade();
				List<Balade> listeBalade = daoBalade.find();
				for(int i = 0; i < listeBalade.size();i++) {
					if(listeBalade.get(i).getNomBalade() == comboBalade.getSelectedItem()) {
						balade.setIdBalade(listeBalade.get(i).getIdBalade());
					}
				}
				
				//Vérification si les champs sont vides et ajout du véhicule
				if(!txtImmatriculation.getText().equals("") && !txtPlaceMembre.getText().equals("") && !txtPlaceVelo.getText().equals("")) {
					if(daoVehicule.create(vehicule)) {
						if(daoVehicule.addVehiculeBalade(txtImmatriculation.getText(), balade.getIdBalade(), membre.getIdPersonne())) {
							dispose();
							GererDisponibilites gererDisponibilites = new GererDisponibilites(membre);
							gererDisponibilites.setTitle("Gérer les disponibilités");
							gererDisponibilites.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Inscription ratée");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Un ou plusieurs champs sont vides");
				}
			}
		});
		btnAjouter.setBounds(10, 164, 100, 30);
		contentPane.add(btnAjouter);
		
		//Bouton retour
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage gérer les disponibilités
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(membre);
				gererDisponibilites.setTitle("Gérer les disponibilités");
				gererDisponibilites.setVisible(true);
			}
		});
		Retour.setBounds(244, 164, 120, 30);
		contentPane.add(Retour);
	}
}
