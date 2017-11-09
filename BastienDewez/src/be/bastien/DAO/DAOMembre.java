package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Membre;
import be.bastien.metier.Personne;

public class DAOMembre extends DAO<Membre>{
	public DAOMembre(Connection conn){
		super(conn);
	}
	
	public boolean create(Membre membre) {
		return false;
	}
	
	public boolean delete(Membre membre) {
		return false;
	}
	
	public boolean update(Membre membre) {
		return false;
	}
	
	public Membre find(Membre membre) {	
		return membre;
	}
	
	public boolean find(Personne personne) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MEMBRE WHERE IdMembre = " + personne.getIdPersonne());
			if(result.next()){
				trouve = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return trouve;
	}
}
