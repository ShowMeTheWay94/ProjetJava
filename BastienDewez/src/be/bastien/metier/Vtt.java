package be.bastien.metier;

import java.io.Serializable;

public class Vtt extends Categorie implements Serializable {
	private static final long serialVersionUID = -7507320119939123463L;
	
	//Variable d'instance
	private int nbrPlateau;
	private String typeRoue;
	
	//Constructeur
	public Vtt() { 
		super();
	}
	
	//Getters et Setters
	public int getNbrPlateau() {
		return nbrPlateau;
	}

	public void setNbrPlateau(int nbrPlateau) {
		this.nbrPlateau = nbrPlateau;
	}

	public String getTypeRoue() {
		return typeRoue;
	}

	public void setTypeRoue(String typeRoue) {
		this.typeRoue = typeRoue;
	}
}
