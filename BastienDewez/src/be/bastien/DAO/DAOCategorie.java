package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOCategorie;

public class DAOCategorie extends DAO<POJOCategorie> {
	public DAOCategorie(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOCategorie categorie) {
		return false;
	}
	
	public boolean delete(POJOCategorie categorie) {
		return false;
	}
	
	public boolean update(POJOCategorie categorie) {
		return false;
	}
	
	public boolean find(POJOCategorie categorie) {	
		boolean trouve = false;
		
		return trouve;
	}
}
