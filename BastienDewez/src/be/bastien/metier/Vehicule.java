package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Vehicule implements Serializable {
	private static final long serialVersionUID = 168084761600626678L;

	//Variable d'instance
	private String numImmatriculation;
	private Membre conducteur;
	private List<Membre> listMembre;
	private int placeLibreMembre;
	private int placeLibreVelo;
	
	//Constructeur
	public Vehicule() { }
	
	//Getters et Setters	
	public String getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(String numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public Membre getConducteur() {
		return conducteur;
	}

	public void setConducteur(Membre conducteur) {
		this.conducteur = conducteur;
	}

	public List<Membre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<Membre> listMembre) {
		this.listMembre = listMembre;
	}

	public int getPlaceLibreMembre() {
		return placeLibreMembre;
	}

	public void setPlaceLibreMembre(int placeLibreMembre) {
		this.placeLibreMembre = placeLibreMembre;
	}

	public int getPlaceLibreVelo() {
		return placeLibreVelo;
	}

	public void setPlaceLibreVelo(int placeLibreVelo) {
		this.placeLibreVelo = placeLibreVelo;
	}
	
	public void addMembre(Membre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(Membre membre){
		this.listMembre.remove(membre);
	}
	
	public void retirerPlaceMembre() {
		int placeMembre = getPlaceLibreMembre();
		placeMembre--;
		setPlaceLibreMembre(placeMembre);
	}
	
	public void retirerPlaceVelo() {
		int placeVelo = getPlaceLibreVelo();
		placeVelo--;
		setPlaceLibreVelo(placeVelo);
	}
}
