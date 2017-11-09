package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Personne;
import be.bastien.metier.Tresorier;

public class DAOTresorier extends DAO<Tresorier>{
	public DAOTresorier(Connection conn){
		super(conn);
	}
	
	public boolean create(Tresorier tresorier) {
		return false;
	}
	
	public boolean delete(Tresorier tresorier) {
		return false;
	}
	
	public boolean update(Tresorier tresorier) {
		return false;
	}
	
	public Tresorier find(Tresorier tresorier) {
		return tresorier;
	}
	
	public boolean find(Personne personne) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM TRESORIER WHERE IdTresorier = " + personne.getIdPersonne());
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
