package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.DAO.DAOBalade;
import be.bastien.DAO.DAOVehicule;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Membre;
import be.bastien.metier.Vehicule;

public class GererDisponibilites extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public GererDisponibilites(Membre membre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblDisponibilites = new JLabel("Nom Balade - Immatriculation - Place Membre - Place Vélo");
		lblDisponibilites.setBounds(20,20,340,20);
		contentPane.add(lblDisponibilites);
		
		//Initialisation de la comboBox
		JComboBox<String> cmBoxDisponibilites = new JComboBox<String>();
		DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
		List<String> listeDisponiblites = daoBalade.findDisponibilites();
		for(int i = 0;i < listeDisponiblites.size();i++) {
			cmBoxDisponibilites.addItem(listeDisponiblites.get(i));
		}
		cmBoxDisponibilites.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxDisponibilites);
		
		//Bouton ajouter disponiblités
		JButton Ajouter = new JButton("Ajouter disponibilités");
		Ajouter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage ajouter disponibilités
				dispose();
				AjouterDisponibilites ajouterDisponibilites = new AjouterDisponibilites(membre);
				ajouterDisponibilites.setTitle("Ajouter Disponiblités");
				ajouterDisponibilites.setVisible(true);
			}
		});
		Ajouter.setBounds(94, 64, 180, 30);
		contentPane.add(Ajouter);
		
		//Bouton réserver place membre
		JButton ReserverPlaceMembre = new JButton("Réserver place membre");
		ReserverPlaceMembre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation des daoBalade et daoVehicule
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				
				//Récupération de la ligne sélectionnées dans la comboBox
				String disponibilites = (String)cmBoxDisponibilites.getSelectedItem();
				String placeMembre = disponibilites.substring(disponibilites.length()-3, disponibilites.length()-2);
				String placeVelo = disponibilites.substring(disponibilites.length()-1, disponibilites.length());
				
				//Instanciation et initialisation des variables du véhicule
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(disponibilites.substring(disponibilites.indexOf(" ") + 1,disponibilites.indexOf(" ",disponibilites.indexOf(" ") + 1)));
				vehicule.setPlaceLibreMembre(Integer.parseInt(placeMembre));
				vehicule.setPlaceLibreVelo(Integer.parseInt(placeVelo));
				
				//Décrémenter la variable placeMembre du véhicule
				if(vehicule.getPlaceLibreMembre() != 0) {
					vehicule.retirerPlaceMembre();
				}
				
				//Mise à jour du véhicule
				daoVehicule.update(vehicule);
				
				//Affichage gérer disponibilités
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(membre);
				gererDisponibilites.setTitle("Gérer les disponibilités");
				gererDisponibilites.setVisible(true);
			}
		});
		ReserverPlaceMembre.setBounds(94, 94, 180, 30);
		contentPane.add(ReserverPlaceMembre);
		
		//Bouton réserver place vélo
		JButton ReserverPlaceVelo = new JButton("Réserver place vélo");
		ReserverPlaceVelo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation du daoVehicule
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				
				//Récupération de la ligne sélectionnées dans la comboBox
				String disponibilites = (String)cmBoxDisponibilites.getSelectedItem();
				String placeMembre = disponibilites.substring(disponibilites.length()-3, disponibilites.length()-2);
				String placeVelo = disponibilites.substring(disponibilites.length()-1, disponibilites.length());
				
				//Instanciation et initialisation des variables du véhicule
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(disponibilites.substring(disponibilites.indexOf(" ") + 1,disponibilites.indexOf(" ",disponibilites.indexOf(" ") + 1)));
				vehicule.setPlaceLibreMembre(Integer.parseInt(placeMembre));
				vehicule.setPlaceLibreVelo(Integer.parseInt(placeVelo));
				
				//Décrémenter la variable placeVelo du véhicule
				if(vehicule.getPlaceLibreVelo() != 0) {
					vehicule.retirerPlaceVelo();
				}
				
				//Mise à jour du véhicule
				daoVehicule.update(vehicule);
				
				//Affichage gérer les disponibilités
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(membre);
				gererDisponibilites.setTitle("Gérer les disponibilités");
				gererDisponibilites.setVisible(true);
			}
		});
		ReserverPlaceVelo.setBounds(94, 124, 180, 30);
		contentPane.add(ReserverPlaceVelo);
		
		//Bouton retour
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage accueil membre
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre(membre);
				acceuilMembre.setTitle("Accueil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(244, 164, 120, 30);
		contentPane.add(Retour);
	}
}
