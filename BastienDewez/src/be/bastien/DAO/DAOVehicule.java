package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Membre;
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
	
	public int nbrVehicule() {
		int nbr = 1;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) NBR FROM VEHICULE");
			if(result.first()) {
				nbr = result.getInt("NBR");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return nbr;
	}
	
	public int nbrVehiculeDifferent(String numImmatriculation) {
		int nbr = 0;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) NBR FROM BALADE_VEHICULE WHERE NUMIMMATRICULATION = '" + numImmatriculation + "'");
			if(result.first()) {
				nbr = result.getInt("NBR");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return nbr;
	}
}
