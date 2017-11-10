package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.*;

public class DAOMembre extends DAO<Membre>{
	public DAOMembre(Connection conn){
		super(conn);
	}
	
	public boolean create(Membre membre) {
		try{
			String strCreate = "INSERT INTO MEMBRE (IDMEMBRE,COTISATION,STATUTCOTISATION) VALUES (" + membre.getIdPersonne() + ","
			+ membre.getCotisation() + ",'" + membre.getStatutCotisation() + "');";
			PreparedStatement s = this.connect.prepareStatement(strCreate);
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
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
			return false;
		}
		
		return trouve;
	}
}
