package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Membre;
import be.bastien.metier.Vehicule;

public class DAOVehicule extends DAO<Vehicule> {
	public DAOVehicule(Connection conn){
		super(conn);
	}
	
	//Fonction pour cr�er un v�hicule
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
	
	//Fonction pour supprimer un v�hicule
	public boolean delete(Vehicule vehicule) {
		return false;
	}
	
	//Fonction pour mettre � jour un v�hicule
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
	
	//Fonctions pour trovuer un v�hicule
	public Vehicule find(Vehicule vehicule) {	
		return vehicule;
	}
	
	public Vehicule find(int idBalade) {
		Vehicule vehicule = new Vehicule();
		DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM BALADE_VEHICULE WHERE IDBALADE = " + idBalade);
			while(result.next()) {
				Membre membre = new Membre();
				vehicule.setNumImmatriculation(result.getString("NUMIMMATRICULATION"));
				membre.setIdPersonne(find(vehicule.getNumImmatriculation()));
				vehicule.setConducteur(daoMembre.find(membre));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vehicule;
	}
	
	public int find(String numImmatriculation) {
		int idMembre = 0;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM VEHICULE WHERE NUMIMMATRICULATION = " + numImmatriculation);
			if(result.first()) {
				idMembre = result.getInt("IDMEMBRE");				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return idMembre;
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
