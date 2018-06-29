package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Vehicule;

public class DAOVehicule extends DAO<Vehicule> {
	public DAOVehicule(Connection conn){
		super(conn);
	}
	
	//Fonction pour créer un véhicule
	public boolean create(Vehicule vehicule) {
		try{
			if(!findVehicule(vehicule)){
				String strCreate = "INSERT INTO VEHICULE VALUES ('" + vehicule.getNumImmatriculation() + "',"
				+ vehicule.getPlaceLibreMembre() + "," + vehicule.getPlaceLibreVelo() + "," + vehicule.getConducteur().getIdPersonne() + ");";
				PreparedStatement s = this.connect.prepareStatement(strCreate);
				s.executeUpdate();
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Fonction pour supprimer un véhicule
	public boolean delete(Vehicule vehicule) {
		return false;
	}
	
	//Fonction pour mettre à jour un véhicule
	public boolean update(Vehicule vehicule) {
		try{
			String strUpdate = "UPDATE VEHICULE SET NBRPLACEMEMBRE = ? , NBRPLACEVELO = ? WHERE NUMIMMATRICULATION = '" + vehicule.getNumImmatriculation() + "';";
			PreparedStatement s = this.connect.prepareStatement(strUpdate);
			s.setInt(1, vehicule.getPlaceLibreMembre());
			s.setInt(2, vehicule.getPlaceLibreVelo());
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//Fonctions pour trovuer un véhicule
	public List<Vehicule> find() {	
		List<Vehicule> listVehicule = new ArrayList<Vehicule>();
		
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM VEHICULE");
			while(result.next()) {
				Vehicule vehicule = new Vehicule();
				vehicule.setNumImmatriculation(result.getString("NUMIMMATRICULATION"));
				vehicule.setPlaceLibreMembre(result.getInt("NBRPLACEMEMBRE"));
				vehicule.setPlaceLibreVelo(result.getInt("NBRPLACEVELO"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listVehicule;
	}
	
	public boolean findVehicule(Vehicule vehicule) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM VEHICULE WHERE NUMIMMATRICULATION = '" + vehicule.getNumImmatriculation() + "'");
			if(result.next()){
				trouve = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return trouve;
	}
}
