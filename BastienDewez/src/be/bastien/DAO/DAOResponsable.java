package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOResponsable;

public class DAOResponsable extends DAO<POJOResponsable> {
	public DAOResponsable(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOResponsable balade) {
		return false;
	}
	
	public boolean delete(POJOResponsable balade) {
		return false;
	}
	
	public boolean update(POJOResponsable balade) {
		return false;
	}
	
	public POJOResponsable find(int id) {
		POJOResponsable responsable = new POJOResponsable();
		
		return responsable;
	}
}
