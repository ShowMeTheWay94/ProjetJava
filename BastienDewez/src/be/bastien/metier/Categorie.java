package be.bastien.metier;

import java.io.Serializable;

public class Categorie implements Serializable {
	private static final long serialVersionUID = 7742525273144891592L;
	
	//Variable d'instance
	private int idCategorie;
	private String nomCategorie;
	private int nbrMembres;
	private int supplement;
	private Calendrier calendrier;

	//Constructeur
	public Categorie() { }

	//Getters et Setters
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	public int getNbrMembres() {
		return nbrMembres;
	}

	public void setNbrMembres(int nbrMembres) {
		this.nbrMembres = nbrMembres;
	}

	public int getSupplement() {
		return supplement;
	}

	public void setSupplement(int supplement) {
		this.supplement = supplement;
	}
	
	public Calendrier getPojoCalendrier() {
		return calendrier;
	}

	public void setPojoCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}
	
	public String toString() {
		return getNomCategorie() + " " + getSupplement();
	}
}
