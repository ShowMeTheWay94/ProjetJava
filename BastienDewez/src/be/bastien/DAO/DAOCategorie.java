package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOCategorie;

public class DAOCategorie extends DAO<POJOCategorie> {
	public DAOCategorie(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOCategorie balade) {
		return false;
	}
	
	public boolean delete(POJOCategorie balade) {
		return false;
	}
	
	public boolean update(POJOCategorie balade) {
		return false;
	}
	
	public POJOCategorie find(int id) {
		POJOCategorie categorie = new POJOCategorie();
		
		return categorie;
	}
}
