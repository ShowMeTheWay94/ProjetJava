package be.bastien.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import be.bastien.metier.Personne;

public class DAOPersonne extends DAO<Personne> {
	public DAOPersonne(Connection conn){
		super(conn);
	}
	
	public boolean create(Personne personne) {
		Statement statement = null;
		ResultSet idGenere = null;
		try {
			if(!findPersonne(personne)){
				statement = connect.createStatement();
<<<<<<< HEAD
				statement.executeUpdate("INSERT INTO Personne(NOM,PRENOM,LOGIN,PASSWORD)" + 
						"VALUES('"+ personne.getNom() + "','" + personne.getPrenom() + "','" + personne.getLogin() + "','"
						+ personne.getPassword() + "')");
=======
				statement.executeUpdate("INSERT INTO PERSONNE (NOM,PRENOM,LOGIN,PASSWORD) VALUES ('" + personne.getNom() + "'," + 
				"'" + personne.getPrenom() + "','" + personne.getLogin() + "','" + personne.getPassword() + "');");
>>>>>>> Acceuil
				idGenere = statement.getGeneratedKeys();
				if(idGenere.next())
					personne.setIdPersonne(idGenere.getInt(1));
				else
<<<<<<< HEAD
					System.out.println("Pas d'ID enregistré");
=======
					JOptionPane.showMessageDialog(null, "Pas d'ID enregistré");
>>>>>>> Acceuil
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
	
	public boolean delete(Personne personne) {
		return false;
	}
	
	public boolean update(Personne personne) {
		return false;
	}
	
	public Personne find(Personne personne) {	
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE");
			while(result.next()){
				if(result.getString("LOGIN").equals(personne.getLogin()) && result.getString("PASSWORD").equals(personne.getPassword())){
					personne.setIdPersonne(result.getInt("IdPersonne"));
					personne.setNom(result.getString("Nom"));
					personne.setPrenom("Prenom");
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
