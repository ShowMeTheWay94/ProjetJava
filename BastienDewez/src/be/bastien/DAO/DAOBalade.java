package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Balade;

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
		try{
			String strUpdate = "UPDATE BALADE SET FORFAIT = ? WHERE IDBALADE = " + balade.getIdBalade() + ";";
			PreparedStatement s = this.connect.prepareStatement(strUpdate);
			s.setDouble(1, balade.getForfait());
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Balade find(Balade balade) {	
		return balade;
	}
	
	public Balade find(int idBalade){
		Balade balade = new Balade();
		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM BALADE WHERE IDBALADE = " + idBalade);
			while(result.next()) {
				balade.setIdBalade(result.getInt("IDBALADE"));
				balade.setNomBalade(result.getString("NOMBALADE"));
				balade.setLieuDepart(result.getString("LIEU"));
				balade.setDateBalade(result.getDate("DATEBALADE"));
				balade.setForfait(result.getDouble("FORFAIT"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return balade;
	}
	
	public int nbrBalade() {
		int nbr = 1;
		
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
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) NBR FROM BALADE_VEHICULE WHERE IDBALADE = " + idBalade);
			if(result.first()) {
				nbr = result.getInt("NBR");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return nbr;
	}
	
	public List<Balade> find(){
		List<Balade> listeBalade = new ArrayList<Balade>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BALADE");
			while(result.next()){
				Balade balade = new Balade();
				balade.setIdBalade(result.getInt("IDBALADE"));
				balade.setNomBalade(result.getString("NOMBALADE"));
				balade.setLieuDepart(result.getString("LIEU"));
				balade.setDateBalade(result.getDate("DATEBALADE"));
				balade.setForfait(result.getDouble("FORFAIT"));
				listeBalade.add(balade);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listeBalade;
	}
}
