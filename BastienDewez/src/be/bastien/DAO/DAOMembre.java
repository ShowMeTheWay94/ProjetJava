package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOMembre;

public class DAOMembre extends DAO<POJOMembre>{
	public DAOMembre(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOMembre balade) {
		return false;
	}
	
	public boolean delete(POJOMembre balade) {
		return false;
	}
	
	public boolean update(POJOMembre balade) {
		return false;
	}
	
	public POJOMembre find(int id) {
		POJOMembre membre = new POJOMembre();
		
		return membre;
	}
}
