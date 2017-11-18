package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Membre;
import be.bastien.metier.Personne;

public class PaiementCotisation extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public PaiementCotisation(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCotisation = new JLabel("Nom - Prénom - Statut Cotisation");
		lblCotisation.setBounds(95,20,200,20);
		contentPane.add(lblCotisation);
		
		//Initialisation de la comboBox
		JComboBox<String> cmBoxCotisation = new JComboBox<String>();
		DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
		List<Membre> listeMembre = daoMembre.find();
		for(int i = 0;i < listeMembre.size();i++) {
			cmBoxCotisation.addItem(listeMembre.get(i).toString());
		}	
		cmBoxCotisation.setBounds(90, 40, 200, 20);
		contentPane.add(cmBoxCotisation);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
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
