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
import be.bastien.metier.Balade;
import be.bastien.metier.Personne;
import be.bastien.metier.Vehicule;

public class GererDisponibilites extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public GererDisponibilites(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblDisponibilites = new JLabel("Nom Balade - Immatriculation - Place Membre - Place V�lo");
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
		
		JButton Ajouter = new JButton("Ajouter disponibilit�s");
		Ajouter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AjouterDisponibilites ajouterDisponibilites = new AjouterDisponibilites(personne);
				ajouterDisponibilites.setTitle("Ajouter Disponiblit�s");
				ajouterDisponibilites.setVisible(true);
			}
		});
		Ajouter.setBounds(94, 64, 180, 30);
		contentPane.add(Ajouter);
		
		JButton ReserverPlaceMembre = new JButton("R�server place membre");
		ReserverPlaceMembre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation des daoBalade et daoVehicule
				DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				
				//R�cup�ration de la ligne s�lectionn�es dans la comboBox
				String disponibilites = (String)cmBoxDisponibilites.getSelectedItem();
				String placeMembre = disponibilites.substring(disponibilites.length()-3, disponibilites.length()-2);
				String placeVelo = disponibilites.substring(disponibilites.length()-1, disponibilites.length());
				
				//Instanciation et initialisation des variables du v�hicule
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(disponibilites.substring(disponibilites.indexOf(" ") + 1,disponibilites.indexOf(" ") + 2));
				vehicule.setPlaceLibreMembre(Integer.parseInt(placeMembre));
				vehicule.setPlaceLibreVelo(Integer.parseInt(placeVelo));
				
				//D�cr�menter la variable placeMembre du v�hicule
				vehicule.retirerPlaceMembre();
				
				//Instanciation et initialisation des variables de la balade
				Balade balade = new Balade();
				balade.setNomBalade(disponibilites.substring(0, disponibilites.indexOf(" ")));
				balade = daoBalade.find(balade);
				
				//Mise � jour du v�hicule
				daoVehicule.update(vehicule);
				
				//Ajout dans la table balade_vehicule
				daoBalade.addDisponibilites(vehicule.getNumImmatriculation(),balade.getIdBalade(),personne.getIdPersonne());
				
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(personne);
				gererDisponibilites.setTitle("G�rer les disponibilit�s");
				gererDisponibilites.setVisible(true);
			}
		});
		ReserverPlaceMembre.setBounds(94, 94, 180, 30);
		contentPane.add(ReserverPlaceMembre);
		
		JButton ReserverPlaceVelo = new JButton("R�server place v�lo");
		ReserverPlaceVelo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Instanciation du daoVehicule
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				
				//R�cup�ration de la ligne s�lectionn�es dans la comboBox
				String disponibilites = (String)cmBoxDisponibilites.getSelectedItem();
				String placeMembre = disponibilites.substring(disponibilites.length()-3, disponibilites.length()-2);
				String placeVelo = disponibilites.substring(disponibilites.length()-1, disponibilites.length());
				
				//Instanciation et initialisation des variables du v�hicule
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(disponibilites.substring(disponibilites.indexOf(" ") + 1,disponibilites.indexOf(" ") + 2));
				vehicule.setPlaceLibreMembre(Integer.parseInt(placeMembre));
				vehicule.setPlaceLibreVelo(Integer.parseInt(placeVelo));
				
				//D�cr�menter la variable placeVelo du v�hicule
				vehicule.retirerPlaceVelo();
				
				//Mise � jour du v�hicule
				daoVehicule.update(vehicule);
				
				dispose();
				GererDisponibilites gererDisponibilites = new GererDisponibilites(personne);
				gererDisponibilites.setTitle("G�rer les disponibilit�s");
				gererDisponibilites.setVisible(true);
			}
		});
		ReserverPlaceVelo.setBounds(94, 124, 180, 30);
		contentPane.add(ReserverPlaceVelo);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre(personne);
				acceuilMembre.setTitle("Acceuil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(244, 164, 120, 30);
		contentPane.add(Retour);
	}
}
