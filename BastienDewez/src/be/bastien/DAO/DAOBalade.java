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
	
	//Fonction pour cr�er une balade
	public boolean create(Balade balade) {
		try{
			if(!findBalade(balade)) {
				String strCreate = "INSERT INTO BALADE (NOMBALADE,LIEU,DATEBALADE,FORFAIT,IDCATEGORIE) VALUES ('" + balade.getNomBalade()
				+ "','" + balade.getLieuDepart() + "','" + balade.getDateBalade() + "'," + balade.getForfait() + "," + balade.getCategorie().getIdCategorie() + ");";
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
	
	//Fonction pour supprimer une balade
	public boolean delete(Balade balade) {
		try{
			String strDelete = "DELETE FROM BALADE WHERE NOMBALADE = '" + balade.getNomBalade() + "';";
			PreparedStatement s = this.connect.prepareStatement(strDelete);
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//Fonction pour mettre � jour une balade
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
	
	//Fonction pour trouver une balade
	public List<Balade> find(){
		List<Balade> listeBalade = new ArrayList<Balade>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BALADE");
			while(result.next()){
				Balade balade = new Balade();
				balade.setIdBalade(result.getInt("IDBALADE"));
				balade.setNomBalade(result.getString("NOMBALADE"));
				balade.setLieuDepart(result.getString("LIEU"));
				balade.setDateBalade(result.getString("DATEBALADE"));
				balade.setForfait(result.getDouble("FORFAIT"));
				listeBalade.add(balade);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listeBalade;
	}
	
	public boolean findBalade(Balade balade) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BALADE WHERE IdBalade = " + balade.getIdBalade());
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
	
	//Fonction qui permet de retrouver les disponibilit�s
	public List<String> findDisponibilites(){
		List<String> listeDisponibilites = new ArrayList<String>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BALADE B INNER JOIN BALADE_VEHICULE BV "
					+ "ON B.IDBALADE = BV.IDBALADE INNER JOIN VEHICULE V ON BV.NUMIMMATRICULATION = V.NUMIMMATRICULATION");
			while(result.next()){
				String disponibilites = result.getString("NOMBALADE") + " " + result.getString("NUMIMMATRICULATION") + " " + result.getInt("NBRPLACEMEMBRE") + " " + result.getInt("NBRPLACEVELO");
				listeDisponibilites.add(disponibilites);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listeDisponibilites;
	}
	
	//Fonction pour retourner les chauffeurs et balades
	public List<String> findRemboursement(){
		List<String> listeRemboursement = new ArrayList<String>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM BALADE_VEHICULE BV INNER JOIN BALADE B "
					+ "ON B.IDBALADE = BV.IDBALADE INNER JOIN VEHICULE V ON BV.NUMIMMATRICULATION = V.NUMIMMATRICULATION INNER JOIN"
					+ " PERSONNE P ON V.IDMEMBRE = P.IDPERSONNE");
			while(result.next()){
				String disponibilites = result.getString("NOM") + " " + result.getString("PRENOM") + " " + result.getString("NOMBALADE") + " " + result.getString("LIEU") + " " + result.getString("DATEBALADE") + " " + result.getInt("FORFAIT");
				listeRemboursement.add(disponibilites);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listeRemboursement;
	}
	
	//Fonction pour ajouter dans la table balade_vehicule
	public boolean addDisponibilites(String numImmatriculation,int idBalade, int idMembre) {
		try{
			String strCreate = "INSERT INTO BALADE_VEHICULE VALUES ('" + numImmatriculation	+ "','" + idBalade + "','" + idMembre + "');";
			PreparedStatement s = this.connect.prepareStatement(strCreate);
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
