package be.bastien.DAO;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import be.bastien.metier.Personne;

public class DAOPersonne extends DAO<Personne> {
	public DAOPersonne(Connection conn){
		super(conn);
	}

	//Fonction pour créer une personne
	public boolean create(Personne personne) {
		Statement statement = null;
		ResultSet idGenere = null;

		try {
			if(!findPersonne(personne)){
				statement = connect.createStatement();
				statement.executeUpdate("INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD) VALUES ('" + personne.getNom() + "'," + 
				"'" + personne.getPrenom() + "','" + personne.getLogin() + "','" + personne.getPassword() + "');");
				idGenere = statement.getGeneratedKeys();
				if(idGenere.next())
					personne.setIdPersonne(idGenere.getInt(1));
				else
					JOptionPane.showMessageDialog(null, "Pas d'ID enregistré");
				statement.close();

				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//Fonction pour supprimer une personne
	public boolean delete(Personne personne) {
		return false;
	}

	//Fonction pour mettre à jour une personne
	public boolean update(Personne personne) {
		return false;
	}

	//Fonction pour trouver une personne
	public List<Personne> find() {	
		List<Personne> listPersonne = new ArrayList<Personne>();
		
		try {
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE");
			while(result.next()) {
				Personne personne = new Personne();
				personne.setIdPersonne(result.getInt("IDPERSONNE"));
				personne.setLogin(result.getString("LOGIN"));
				personne.setNom(result.getString("NOM"));
				personne.setPassword(result.getString("PASSWORD"));
				personne.setPrenom(result.getString("PRENOM"));
				listPersonne.add(personne);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listPersonne;
	}

	public boolean findPersonne(Personne personne){
		boolean trouve = false;

		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE WHERE LOGIN = '" + personne.getLogin() + "' and PASSWORD = '" + personne.getPassword() + "'");
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
}