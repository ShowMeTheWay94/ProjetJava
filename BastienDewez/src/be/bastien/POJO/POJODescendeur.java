package be.bastien.POJO;

import java.io.Serializable;

public class POJODescendeur extends POJOVtt implements Serializable {
	private static final long serialVersionUID = 6010485200513188698L;

	//Variable d'instance
	private String typeSuspension;
	
	//Constructeur
	public POJODescendeur() { 
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
