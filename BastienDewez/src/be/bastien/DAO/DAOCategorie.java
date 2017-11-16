package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Categorie;
import be.bastien.metier.Personne;

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
			String strUpdate2 = "UPDATE MEMBRE_CATEGORIE SET SUPPLEMENT = ? WHERE IDCATEGORIE = " + categorie.getIdCategorie() + ";";
			PreparedStatement s2 = this.connect.prepareStatement(strUpdate2);
			s2.setInt(1, categorie.getSupplement());
			s2.executeUpdate();
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
	
	public List<Categorie> find(Personne personne){
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM MEMBRE_CATEGORIE MC INNER JOIN CATEGORIE C ON MC.IDCATEGORIE = C.IDCATEGORIE WHERE IDMEMBRE = 5");
			while(result.next()){
				Categorie categorie = new Categorie();
				categorie.setIdCategorie(result.getInt("IDCATEGORIE"));
				categorie.setSupplement(result.getInt("SUPPLEMENT"));
				categorie.setNomCategorie(result.getString("SOUSTYPE"));
				listeCategorie.add(categorie);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return listeCategorie;
	}
}
