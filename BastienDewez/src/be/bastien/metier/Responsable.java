package be.bastien.metier;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Responsable extends Personne implements Serializable {
	private static final long serialVersionUID = -3666600781634000802L;
	
	//Variable d'instance
	private GregorianCalendar dateExpiration;
	
	//Constructeur
	public Responsable() { 
		super();
	}
	
	//Getters et Setters
	public GregorianCalendar getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(GregorianCalendar dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
}
