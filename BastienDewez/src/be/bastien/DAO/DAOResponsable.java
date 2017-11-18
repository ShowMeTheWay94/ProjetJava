package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Personne;
import be.bastien.metier.Responsable;

public class DAOResponsable extends DAO<Responsable> {
	public DAOResponsable(Connection conn){
		super(conn);
	}
	
	//Fonction pour créer un responsable
	public boolean create(Responsable responsable) {
		return false;
	}
	
	//Fonction pour supprimer un responsable
	public boolean delete(Responsable responsable) {
		return false;
	}
	
	//Fonction pour mettre à jour un responsable
	public boolean update(Responsable responsable) {
		return false;
	}
	
	//Fonstions pour trouver un responsable
	public Responsable find(Responsable responsable) {
		return responsable;
	}
	
	public boolean find(Personne personne) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM RESPONSABLE WHERE IdResponsable = " + personne.getIdPersonne());
			if(result.next()){
				trouve = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return trouve;
	}
}
