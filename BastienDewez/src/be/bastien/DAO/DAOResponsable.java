package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.metier.Responsable;

public class DAOResponsable extends DAO<Responsable> {
	public DAOResponsable(Connection conn){
		super(conn);
	}
	
	public boolean create(Responsable responsable) {
		return false;
	}
	
	public boolean delete(Responsable responsable) {
		return false;
	}
	
	public boolean update(Responsable responsable) {
		return false;
	}
	
	public boolean find(Responsable responsable) {
		boolean trouve = false;
		
		return trouve;
	}
}
