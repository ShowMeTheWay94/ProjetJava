package be.bastien.POJO;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class POJOResponsable extends POJOPersonne implements Serializable {
	private static final long serialVersionUID = -3666600781634000802L;
	
	//Variable d'instance
	private GregorianCalendar dateExpiration;
	
	//Constructeur
	public POJOResponsable() { 
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
