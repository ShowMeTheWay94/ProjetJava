package be.bastien.metier;

import java.io.Serializable;
import java.util.Date;

public class Responsable extends Personne implements Serializable {
	private static final long serialVersionUID = -3666600781634000802L;
	
	//Variable d'instance
	private Date dateExpiration;
	
	//Constructeur
	public Responsable() { 
		super();
	}
	
	//Getters et Setters
	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
}
