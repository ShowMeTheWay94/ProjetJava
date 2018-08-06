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
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Personne;

public class RemboursementChauffeur extends JFrame {
	private static final long serialVersionUID = 1420270537310638510L;
	private JPanel contentPane;
	
	public RemboursementChauffeur(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblRemboursement = new JLabel("Nom - Prénom - Nom Balade - Lieu - Date - Forfait");
		lblRemboursement.setBounds(45,20,280,20);
		contentPane.add(lblRemboursement);
		
		//Initialisation de la comboBox
		JComboBox<String> cmBoxRemboursement = new JComboBox<String>();
		DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
		List<String> listeRemboursement = daoBalade.findRemboursement();
		for(int i = 0;i < listeRemboursement.size();i++) {
			cmBoxRemboursement.addItem(listeRemboursement.get(i).toString());
		}
		cmBoxRemboursement.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxRemboursement);
		
		//Bouton retour
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//Affichage accueil trésorier
				dispose();
				AcceuilTresorier acceuilTresorier = new AcceuilTresorier(personne);
				acceuilTresorier.setTitle("Acceuil Tresorier");
				acceuilTresorier.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
}
