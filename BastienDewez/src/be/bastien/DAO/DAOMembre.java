package be.bastien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.bastien.POJO.POJOMembre;

public class DAOMembre extends DAO<POJOMembre>{
	public DAOMembre(Connection conn){
		super(conn);
	}
	
	public boolean create(POJOMembre membre) {
		return false;
	}
	
	public boolean delete(POJOMembre membre) {
		return false;
	}
	
	public boolean update(POJOMembre membre) {
		return false;
	}
	
	public boolean find(POJOMembre membre) {	
		boolean trouve = false;
		
		try{
			ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM PERSONNE");
			while(result.next()){
				if(result.getString("LOGIN").equals(membre.getLogin()) && result.getString("PASSWORD").equals(membre.getPassword())){
					trouve = true;
				}
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return trouve;
	}
}
