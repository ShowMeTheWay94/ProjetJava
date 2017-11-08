package be.bastien.metier;

import java.io.Serializable;

public class Trialiste extends Vtt implements Serializable {
	private static final long serialVersionUID = -8929728861169228577L;
	
	//Variable d'instance
	private boolean scelle;
	
	//Constructeur
	public Trialiste() { 
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
