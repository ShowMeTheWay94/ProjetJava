package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.*;

public class DAOMembre extends DAO<Membre>{
	public DAOMembre(Connection conn){
		super(conn);
	}
	
	//Fonction pour cr�er un membre
	public boolean create(Membre membre) {
		try{
			if(!findMembre(membre)){
				String strCreate = "INSERT INTO MEMBRE (IDMEMBRE,COTISATION,STATUTCOTISATION) VALUES (" + membre.getIdPersonne() + ","
				+ membre.getCotisation() + ",'" + membre.getStatutCotisation() + "');";
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
	
	//Fonction pour supprimer un membre
	public boolean delete(Membre membre) {
		return false;
	}
	
	//Fonction pour mettre � jour un membre
	public boolean update(Membre membre) {
		try{
			String strUpdate = "UPDATE MEMBRE SET COTISATION = ?,STATUTCOTISATION = ? WHERE IDMEMBRE = " + membre.getIdPersonne() + ";";
			PreparedStatement s = this.connect.prepareStatement(strUpdate);
			s.setInt(1, membre.getCotisation());
			s.setString(2, membre.getStatutCotisation());
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//Fonctions pour trouver un membre
	public Membre find(Membre membre) {		
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM PERSONNE WHERE IDPERSONNE = " + membre.getIdPersonne());
			if(result.first()) {
				membre.setNom(result.getString("NOM"));
				membre.setPrenom(result.getString("PRENOM"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return membre;
	}
	
	public List<Membre> find(){
		List<Membre> listMembre = new ArrayList<Membre>();
		
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MEMBRE M INNER JOIN PERSONNE P ON M.IDMEMBRE "
					+ "= P.IDPERSONNE");
			while(result.next()) {
				Membre membre = new Membre();
				membre.setNom(result.getString("NOM"));
				membre.setPrenom(result.getString("PRENOM"));
				membre.setCotisation(result.getInt("COTISATION"));
				membre.setStatutCotisation(result.getString("STATUTCOTISATION"));
				listMembre.add(membre);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listMembre;
	}
	
	public boolean find(Personne personne) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MEMBRE WHERE IdMembre = " + personne.getIdPersonne());
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
	
	public boolean findMembre(Membre membre) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MEMBRE WHERE IdMembre = " + membre.getIdPersonne());
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
	
	//Fonction pour ajouter dans la table membre_cat�gorie
	public boolean addCategorie(Membre membre, Categorie categorie) {
		try {
			String strCreate = "INSERT INTO MEMBRE_CATEGORIE (IDMEMBRE,IDCATEGORIE,SUPPLEMENT) VALUES (" + membre.getIdPersonne() + ","
				+ categorie.getIdCategorie() + "," + categorie.getSupplement() + ");";
			PreparedStatement s = this.connect.prepareStatement(strCreate);
			s.executeUpdate();		
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
