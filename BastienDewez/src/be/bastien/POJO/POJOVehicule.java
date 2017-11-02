package be.bastien.POJO;

import java.io.Serializable;
import java.util.List;

public class POJOVehicule implements Serializable {
	private static final long serialVersionUID = 168084761600626678L;

	//Variable d'instance
	private int idVehicule;
	private int numImmatriculation;
	private POJOMembre conducteur;
	private List<POJOMembre> listMembre;
	private int placeLibreMembre;
	private int placeLibreVelo;
	
	//Constructeur
	public POJOVehicule() { }
	
	//Getters et Setters
	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}
	
	public int getNumImmatriculation() {
		return numImmatriculation;
	}

	public void setNumImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public POJOMembre getConducteur() {
		return conducteur;
	}

	public void setConducteur(POJOMembre conducteur) {
		this.conducteur = conducteur;
	}

	public List<POJOMembre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<POJOMembre> listMembre) {
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
	
	public void addMembre(POJOMembre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(POJOMembre membre){
		this.listMembre.remove(membre);
	}
}
