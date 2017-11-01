package be.bastien.POJO;

import java.io.Serializable;

public class POJOVtt extends POJOCategorie implements Serializable {
	private static final long serialVersionUID = -7507320119939123463L;
	
	//Variable d'instance
	private int nbrPlateau;
	private String typeRoue;
	
	//Constructeur
	public POJOVtt() { 
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
