package be.bastien.metier;

import java.io.Serializable;

public class Randonneur extends Vtt implements Serializable {
	private static final long serialVersionUID = -5143863980700263605L;

	//Variable d'isntance
	private String typeFourche;
	
	//Constructeur
	public Randonneur() { 
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
