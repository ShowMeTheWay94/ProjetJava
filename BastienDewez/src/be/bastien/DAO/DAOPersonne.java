package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOPersonne;

public class DAOPersonne extends DAO<POJOPersonne> {
	public DAOPersonne(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOPersonne balade) {
		return false;
	}
	
	public boolean delete(POJOPersonne balade) {
		return false;
	}
	
	public boolean update(POJOPersonne balade) {
		return false;
	}
	
	public POJOPersonne find(int id) {
		POJOPersonne personne = new POJOPersonne();
		
		return personne;
	}
}
