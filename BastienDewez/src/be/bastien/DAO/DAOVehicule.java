package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.POJO.POJOVehicule;

public class DAOVehicule extends DAO<POJOVehicule> {
	public DAOVehicule(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOVehicule vehicule) {
		return false;
	}
	
	public boolean delete(POJOVehicule vehicule) {
		return false;
	}
	
	public boolean update(POJOVehicule vehicule) {
		return false;
	}
	
	public boolean find(POJOVehicule vehicule) {	
		boolean trouve = false;
		
		return trouve;
	}
}
