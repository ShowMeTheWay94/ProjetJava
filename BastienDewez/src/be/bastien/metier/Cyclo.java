package be.bastien.metier;

import java.io.Serializable;

public class Cyclo extends Categorie implements Serializable {
	private static final long serialVersionUID = -9215696393555879369L;
	
	//Variable d'instance
	private boolean porteBidon;
	
	//Constructeur
	public Cyclo() { 
		super();
	}
	
	//Getters et Setters
	public boolean getPorteBidon() {
		return porteBidon;
	}

	public void setPorteBidon(boolean porteBidon) {
		this.porteBidon = porteBidon;
	}
}
