package be.bastien.DAO;

import java.sql.Connection;

import be.bastien.metier.Tresorier;

public class DAOTresorier extends DAO<Tresorier>{
	public DAOTresorier(Connection conn){
		super(conn);
	}
	
	public boolean create(Tresorier tresorier) {
		return false;
	}
	
	public boolean delete(Tresorier tresorier) {
		return false;
	}
	
	public boolean update(Tresorier tresorier) {
		return false;
	}
	
	public boolean find(Tresorier tresorier) {
		boolean trouve = false;
		
		return trouve;
	}
}
