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
	
	public Vehicule find(String numImmatriculation) {
		Vehicule vehicule = new Vehicule();
		DAOMembre daoMembre = new DAOMembre(ProjetConnection.getInstance());
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM BALADE_VEHICULE WHERE NUMIMMATRICULATION = '" + numImmatriculation + "'");
			if(result.first()) {
				Membre membre = new Membre();
				membre.setIdPersonne(result.getInt("IDMEMBRE"));
				vehicule.setConducteur(daoMembre.find(membre));
				vehicule.setNumImmatriculation(numImmatriculation);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vehicule;
	}
}
