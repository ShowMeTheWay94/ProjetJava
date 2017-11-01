package be.bastien.POJO;

import java.io.Serializable;

public class POJOTrialiste extends POJOVtt implements Serializable {
	private static final long serialVersionUID = -8929728861169228577L;
	
	//Variable d'instance
	private boolean scelle;
	
	//Constructeur
	public POJOTrialiste() { 
		super();
	}
	
	//Getters et Setters
	public boolean getScelle() {
		return scelle;
	}

	public void setScelle(boolean scelle) {
		this.scelle = scelle;
	}
}
