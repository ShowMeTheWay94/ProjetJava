package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.metier.Vehicule;

public class DAOVehicule extends DAO<Vehicule> {
	public DAOVehicule(Connection conn){
		super(conn);
	}
	
	public boolean create(Vehicule vehicule) {
		return false;
	}
	
	public boolean delete(Vehicule vehicule) {
		return false;
	}
	
	public boolean update(Vehicule vehicule) {
		return false;
	}
	
	public boolean find(Vehicule vehicule) {	
		boolean trouve = false;
		
		return trouve;
	}
}
