package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Responsable;

public class DAOResponsable extends DAO<Responsable> {
	public DAOResponsable(Connection conn){
		super(conn);
	}
	
	//Fonction pour créer un responsable
	public boolean create(Responsable responsable) {
		return false;
	}
	
	//Fonction pour supprimer un responsable
	public boolean delete(Responsable responsable) {
		return false;
	}
	
	//Fonction pour mettre à jour un responsable
	public boolean update(Responsable responsable) {
		return false;
	}
	
	//Fonstions pour trouver un responsable
	public List<Responsable> find() {
		List<Responsable> listResponsable = new ArrayList<Responsable>();
		
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM RESPONSABLE R INNER JOIN PERSONNE P ON R.IDRESPONSABLE "
					+ "= P.IDPERSONNE");
			while(result.next()) {
				Responsable responsable = new Responsable();
				responsable.setDateExpiration(result.getDate("DATEEXPIRATION"));
				responsable.setIdPersonne(result.getInt("IDPERSONNE"));
				responsable.setLogin(result.getString("LOGIN"));
				responsable.setNom(result.getString("NOM"));
				responsable.setPassword(result.getString("PASSWORD"));
				responsable.setPrenom(result.getString("PRENOM"));
				listResponsable.add(responsable);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listResponsable;
	}
}
