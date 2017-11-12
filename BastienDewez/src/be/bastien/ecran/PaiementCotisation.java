package be.bastien.ecran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.bastien.DAO.DAOMembre;
import be.bastien.DAO.ProjetConnection;
import be.bastien.metier.Membre;

public class PaiementCotisation extends JFrame {
	private static final long serialVersionUID = 8491766187158806612L;
	private JPanel contentPane;
	
	public PaiementCotisation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
		
		JComboBox<String> cmBoxCotisation = new JComboBox<String>();
		List<Membre> listeMembre = daoMembre.cotisation();
		for(int i = 0;i < listeMembre.size();i++) {
			cmBoxCotisation.addItem(listeMembre.get(i).toString());
		}	
		cmBoxCotisation.setBounds(90, 20, 200, 20);
		contentPane.add(cmBoxCotisation);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AcceuilTresorier acceuilTresorier = new AcceuilTresorier();
				acceuilTresorier.setTitle("Acceuil Tresorier");
				acceuilTresorier.setVisible(true);
			}
		});
		Retour.setBounds(244, 114, 120, 30);
		contentPane.add(Retour);
	}
}