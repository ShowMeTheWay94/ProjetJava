package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Balade;
import be.bastien.metier.Vehicule;

public class DAOBalade extends DAO<Balade> {
	public DAOBalade(Connection conn){
		super(conn);
	}
	
	public boolean create(Balade balade) {
		return false;
	}
	
	public boolean delete(Balade balade) {
		return false;
	}
	
	public boolean update(Balade balade) {
		return false;
	}
	
	public Balade find(Balade balade) {	
		return balade;
	}
	
	public Balade find(int idBalade){
		Balade balade = new Balade();
		DAOVehicule daoVehicule = new DAOVehicule(ProjetConnection.getInstance());
		List<Vehicule> listeVehicule = new ArrayList<Vehicule>();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM BALADE WHERE IDBALADE = " + idBalade);
			while(result.next()) {
				balade.setIdBalade(result.getInt("IDBALADE"));
				balade.setNomBalade(result.getString("NOMBALADE"));
				balade.setLieuDepart(result.getString("LIEU"));
				balade.setDateBalade(result.getDate("DATEBALADE"));
				balade.setForfait(result.getDouble("FORFAIT"));
				ResultSet result1 = this.connect.createStatement().executeQuery("SELECT NUMIMMATRICULATION FROM BALADE_VEHICULE BV INNER JOIN"
						+ " BALADE B ON BV.IDBALADE = B.IDBALADE WHERE BV.IDBALADE = " + balade.getIdBalade());
				while(result1.next()) {
					Vehicule vehicule = daoVehicule.find(result1.getString("NUMIMMATRICULATION"));
					listeVehicule.add(vehicule);
				}	
				balade.setListVehicule(listeVehicule);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return balade;
	}
	
	public int nbrBalade() {
		int nbr = 0;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) NBR FROM BALADE");
			if(result.first()) {
				nbr = result.getInt("NBR");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return nbr;
	}
	
	public int nbrBaladeDifferente(int idBalade) {
		int nbr = 0;
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(" + idBalade + ") NBR FROM BALADE_VEHICULE");
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
