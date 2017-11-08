package be.bastien.metier;

import java.io.Serializable;

public class Descendeur extends Vtt implements Serializable {
	private static final long serialVersionUID = 6010485200513188698L;

	//Variable d'instance
	private String typeSuspension;
	
	//Constructeur
	public Descendeur() { 
		super();
	}

	//Getters et Setters
	public String getTypeSuspension() {
		return typeSuspension;
	}

	public void setTypeSuspension(String typeSuspension) {
		this.typeSuspension = typeSuspension;
	}
}
