package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOBalade;

public class DAOBalade extends DAO<POJOBalade> {
	public DAOBalade(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOBalade balade) {
		return false;
	}
	
	public boolean delete(POJOBalade balade) {
		return false;
	}
	
	public boolean update(POJOBalade balade) {
		return false;
	}
	
	public boolean find(POJOBalade balade) {
		boolean trouve = false;
		
		return trouve;
	}
}
