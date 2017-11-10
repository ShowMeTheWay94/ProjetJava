package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Personne;

public class DAOPersonne extends DAO<Personne> {
	public DAOPersonne(Connection conn){
		super(conn);
	}
	
	public boolean create(Personne personne) {
		return false;
	}
	
	public boolean delete(Personne personne) {
		return false;
	}
	
	public boolean update(Personne personne) {
		return false;
	}
	
	public Personne find(Personne personne) {	
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE");
			while(result.next()){
				if(result.getString("LOGIN").equals(personne.getLogin()) && result.getString("PASSWORD").equals(personne.getPassword())){
					personne.setIdPersonne(result.getInt("IdPersonne"));
					personne.setNom(result.getString("Nom"));
					personne.setPrenom("Prenom");
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return personne;
	}
}
