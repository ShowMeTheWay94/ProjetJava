package be.bastien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.bastien.metier.Categorie;

public class DAOCategorie extends DAO<Categorie> {
	public DAOCategorie(Connection conn){
		super(conn);
	}
	
	//Fonction pour cr�er une cat�gorie
	public boolean create(Categorie categorie) {
		return false;
	}
	
	//Fonction pour supprimer une cat�gorie
	public boolean delete(Categorie categorie) {
		return false;
	}
	
	//Fonction pour mettre � jour une cat�gorie et la table membre_cat�gorie
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
	
	//Fonction pour trouver les cat�gories
	public List<Categorie> find() {	
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM CATEGORIE");
			while(result.next()){
				Categorie categorie = new Categorie();
				categorie.setIdCategorie(result.getInt("IDCATEGORIE"));
				categorie.setNbrMembres(result.getInt("NBRMEMBRES"));
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
