package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOResponsable;

public class DAOResponsable extends DAO<POJOResponsable> {
	public DAOResponsable(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOResponsable responsable) {
		return false;
	}
	
	public boolean delete(POJOResponsable responsable) {
		return false;
	}
	
	public boolean update(POJOResponsable responsable) {
		return false;
	}
	
	public boolean find(POJOResponsable responsable) {
		boolean trouve = false;
		
		return trouve;
	}
}
