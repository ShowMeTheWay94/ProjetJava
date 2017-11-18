package be.bastien.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import be.bastien.metier.Personne;

public class DAOPersonne extends DAO<Personne> {
	public DAOPersonne(Connection conn){
		super(conn);
	}

	//Fonction pour cr�er une personne
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
					JOptionPane.showMessageDialog(null, "Pas d'ID enregistr�");
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

	//Fonction pour mettre � jour une personne
	public boolean update(Personne personne) {
		return false;
	}

	//Fonctions pour trouver une personne
	public Personne find(Personne personne) {	
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE");

			while(result.next()){
				if(result.getString("LOGIN").equals(personne.getLogin()) && result.getString("PASSWORD").equals(personne.getPassword())){
					personne.setIdPersonne(result.getInt("IdPersonne"));
					personne.setNom(result.getString("Nom"));
					personne.setPrenom("Prenom");
					return personne;
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return personne;
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