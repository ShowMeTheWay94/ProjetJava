package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Tresorier;

public class DAOTresorier extends DAO<Tresorier>{
	public DAOTresorier(Connection conn){
		super(conn);
	}
	
	//Fonction pour créer un trésorier
	public boolean create(Tresorier tresorier) {
		return false;
	}
	
	//Fonction pour supprimer un trésorier
	public boolean delete(Tresorier tresorier) {
		return false;
	}
	
	//Fonction pour mettre à jour un trésorier
	public boolean update(Tresorier tresorier) {
		return false;
	}
	
	//Fonctions pour trouver un trésorier
	public List<Tresorier> find() {
		List<Tresorier> listTresorier = new ArrayList<Tresorier>();
		
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM TRESORIER T INNER JOIN PERSONNE P ON T.IDTRESORIER "
					+ "= P.IDPERSONNE");
			while(result.next()) {
				Tresorier tresorier = new Tresorier();
				tresorier.setIdPersonne(result.getInt("IDPERSONNE"));
				tresorier.setLogin(result.getString("LOGIN"));
				tresorier.setNom(result.getString("NOM"));
				tresorier.setNumCompteCourant(result.getString("COMPTECOURANT"));
				tresorier.setPassword(result.getString("PASSWORD"));
				tresorier.setPrenom(result.getString("PRENOM"));
				listTresorier.add(tresorier);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listTresorier;
	}
}
