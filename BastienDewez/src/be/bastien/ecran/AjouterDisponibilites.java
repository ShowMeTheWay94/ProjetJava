package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.bastien.DAO.DAOVehicule;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Membre;
import be.bastien.metier.Personne;
import be.bastien.metier.Vehicule;

public class AjouterDisponibilites extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public AjouterDisponibilites(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblImmatriculation = new JLabel("Immatriculation :");
		lblImmatriculation.setBounds(70, 24, 100, 14);
		contentPane.add(lblImmatriculation);
		
		JTextField txtImmatriculation = new JTextField();
		txtImmatriculation.setBounds(220, 21, 100, 20);
		contentPane.add(txtImmatriculation);
		
		JLabel lblPlaceMembre = new JLabel("Nombre place membre :");
		lblPlaceMembre.setBounds(70, 64, 140, 14);
		contentPane.add(lblPlaceMembre);
		
		JTextField txtPlaceMembre = new JTextField();
		txtPlaceMembre.setBounds(220, 61, 100, 20);
		contentPane.add(txtPlaceMembre);
		
		
		JLabel lblPlaceVelo = new JLabel("Nombre place v�lo :");
		lblPlaceVelo.setBounds(70, 104, 120, 14);
		contentPane.add(lblPlaceVelo);
		
		JTextField txtPlaceVelo = new JTextField();
		txtPlaceVelo.setBounds(220, 101, 100, 20);
		contentPane.add(txtPlaceVelo);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
				
				Membre membre = new Membre();
				membre.setIdPersonne(personne.getIdPersonne());
				
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(txtImmatriculation.getText());
				vehicule.setPlaceLibreMembre(Integer.parseInt(txtPlaceMembre.getText()));
				vehicule.setPlaceLibreVelo(Integer.parseInt(txtPlaceVelo.getText()));
				vehicule.setConducteur(membre);
				
				if(!txtImmatriculation.getText().equals("") && !txtPlaceMembre.getText().equals("") && !txtPlaceVelo.getText().equals("")) {
					if(daoVehicule.create(vehicule)) {
						dispose();
						GererDisponibilites gererDisponibilites = new GererDisponibilites(personne);
						gererDisponibilites.setTitle("G�rer les disponibilit�s");
						gererDisponibilites.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Inscription rat�e");
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
				GererDisponibilites gererDisponibilites = new GererDisponibilites(personne);
				gererDisponibilites.setTitle("G�rer les disponibilit�s");
				gererDisponibilites.setVisible(true);
			}
		});
		Retour.setBounds(244, 164, 120, 30);
		contentPane.add(Retour);
	}
}