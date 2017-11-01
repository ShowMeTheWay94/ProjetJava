package be.bastien.POJO;

import java.io.Serializable;

public class POJORandonneur extends POJOVtt implements Serializable {
	private static final long serialVersionUID = -5143863980700263605L;

	//Variable d'isntance
	private String typeFourche;
	
	//Constructeur
	public POJORandonneur() { 
		super();
	}

	//Getters et Setters
	public String getTypeFourche() {
		return typeFourche;
	}

	public void setTypeFourche(String typeFourche) {
		this.typeFourche = typeFourche;
	}
}
