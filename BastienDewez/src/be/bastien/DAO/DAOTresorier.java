package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOTresorier;

public class DAOTresorier extends DAO<POJOTresorier>{
	public DAOTresorier(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOTresorier tresorier) {
		return false;
	}
	
	public boolean delete(POJOTresorier tresorier) {
		return false;
	}
	
	public boolean update(POJOTresorier tresorier) {
		return false;
	}
	
	public boolean find(POJOTresorier tresorier) {
		boolean trouve = false;
		
		return trouve;
	}
}
