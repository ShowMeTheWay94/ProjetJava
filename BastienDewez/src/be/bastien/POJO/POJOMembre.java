package be.bastien.POJO;

import java.io.Serializable;

public class POJOMembre extends POJOPersonne implements Serializable {
	private static final long serialVersionUID = 7958552928958704463L;

	//Variable d'instance
	private int cotisation;
	private String statutCotisation;
	
	//Constructeur
	public POJOMembre() { 
		super();
	}
	
	//Getters et Setters
	public int getCotisation() {
		return cotisation;
	}

	public void setCotisation(int cotisation) {
		this.cotisation = cotisation;
	}

	public String getStatutCotisation() {
		return statutCotisation;
	}

	public void setStatutCotisation(String statutCotisation) {
		this.statutCotisation = statutCotisation;
	}
}
