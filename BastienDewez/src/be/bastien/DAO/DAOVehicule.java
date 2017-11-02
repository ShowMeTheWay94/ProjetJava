package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOVehicule;

public class DAOVehicule extends DAO<POJOVehicule> {
	public DAOVehicule(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOVehicule balade) {
		return false;
	}
	
	public boolean delete(POJOVehicule balade) {
		return false;
	}
	
	public boolean update(POJOVehicule balade) {
		return false;
	}
	
	public POJOVehicule find(int id) {
		POJOVehicule vehicule = new POJOVehicule();
		
		return vehicule;
	}
}
