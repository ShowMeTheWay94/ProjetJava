package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.metier.Categorie;

public class DAOCategorie extends DAO<Categorie> {
	public DAOCategorie(Connection conn){
		super(conn);
	}
	
	public boolean create(Categorie categorie) {
		return false;
	}
	
	public boolean delete(Categorie categorie) {
		return false;
	}
	
	public boolean update(Categorie categorie) {
		return false;
	}
	
	public boolean find(Categorie categorie) {	
		boolean trouve = false;
		
		return trouve;
	}
}
