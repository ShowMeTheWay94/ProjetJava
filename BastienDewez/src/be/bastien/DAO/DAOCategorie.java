package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.metier.Categorie;

public class DAOCategorie extends DAO<Categorie> {
	public DAOCategorie(Connection conn){
		super(conn);
	}
	
	public boolean create(Categorie categorie) {
		return false;
	}
	
	public boolean delete(Categorie categorie) {
		return false;
	}
	
	public boolean update(Categorie categorie) {
		try{
			String strUpdate = "UPDATE CATEGORIE SET NBRMEMBRES = ? WHERE IDCATEGORIE = " + categorie.getIdCategorie() + ";";
			PreparedStatement s = this.connect.prepareStatement(strUpdate);
			s.setInt(1, categorie.getNbrMembres());
			s.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Categorie find(Categorie categorie) {	
		return categorie;
	}
	
	public Categorie find(String nomCategorie) {
		Categorie categorie = new Categorie();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM CATEGORIE");
			while(result.next()){
				if(result.getString("SOUSTYPE").equals(nomCategorie)) {
					categorie.setIdCategorie(result.getInt("IDCATEGORIE"));
					categorie.setNbrMembres(result.getInt("NBRMEMBRES"));
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return categorie;
	}
}
