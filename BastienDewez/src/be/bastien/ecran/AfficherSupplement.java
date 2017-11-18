package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.bastien.DAO.DAOCategorie;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Categorie;
import be.bastien.metier.Personne;

public class AfficherSupplement extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public AfficherSupplement(Personne personne) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblSupplement = new JLabel("Nom Categorie - Suppl�ment");
		lblSupplement.setBounds(110,20,280,20);
		contentPane.add(lblSupplement);
		
		JComboBox<Categorie> cmBoxSupplement = new JComboBox<Categorie>();
		DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
		List<Categorie> listeCategorie = daoCategorie.find(personne);
		for(int i = 0;i < listeCategorie.size();i++) {
			cmBoxSupplement.addItem(listeCategorie.get(i));
		}
		cmBoxSupplement.setBounds(10, 40, 350, 20);
		contentPane.add(cmBoxSupplement);
		
		JButton Payer = new JButton("Payer");
		Payer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				DAOCategorie daoCategorie = new DAOCategorie(ProjetConnection.getInstance());
				Categorie categorie = (Categorie)cmBoxSupplement.getSelectedItem();
				categorie.setSupplement(0);
				daoCategorie.update(categorie);
				dispose();
				AfficherSupplement afficherSupplement = new AfficherSupplement(personne);
				afficherSupplement.setTitle("Afficher suppl�ment");
				afficherSupplement.setVisible(true);
			}
		});
		Payer.setBounds(114, 114, 120, 30);
		contentPane.add(Payer);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilMembre acceuilMembre = new AcceuilMembre(personne);
				acceuilMembre.setTitle("Acceuil Membre");
				acceuilMembre.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
}