package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.DAO.DAOBalade;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Balade;
import be.bastien.metier.Personne;

public class RemboursementChauffeur extends JFrame {
	private static final long serialVersionUID = 1420270537310638510L;
	private JPanel contentPane;
	public Personne personne;
	private int nbrBalade;
	private int nbrBaladeDifferente;
	
	public RemboursementChauffeur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblRemboursement = new JLabel("Nom - Pr�nom - Nom Balade - Lieu - Date - Forfait");
		lblRemboursement.setBounds(45,20,280,20);
		contentPane.add(lblRemboursement);
		
		JComboBox<String> cmBoxRemboursement = new JComboBox<String>();
		DAOBalade daoBalade = new DAOBalade(ProjetConnection.getInstance());
		nbrBalade = daoBalade.nbrBalade();
		List<Balade> listeBalade = new ArrayList<Balade>();
		for(int i = 1; i <= nbrBalade; i ++) {
			nbrBaladeDifferente = daoBalade.nbrBaladeDifferente(i);
			for(int j = 0; j < nbrBaladeDifferente; j++) {
				listeBalade.add(daoBalade.find(i));
			}
		}
		for(int i = 0;i < listeBalade.size();i++) {
			cmBoxRemboursement.addItem(listeBalade.get(i).getListVehicule().get(i).getConducteur().getNom() + " " +  listeBalade.get(i).getListVehicule().get(i).getConducteur().getPrenom() + " " + listeBalade.get(i).toString());
		}	
		cmBoxRemboursement.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxRemboursement);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilTresorier acceuilTresorier = new AcceuilTresorier();
				acceuilTresorier.setPersonne(personne);
				acceuilTresorier.setTitle("Acceuil Tresorier");
				acceuilTresorier.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
	
	public Personne getPersonne(){
		return personne;
	}
	
	public void setPersonne(Personne personne){
		this.personne = personne;
	}
}
