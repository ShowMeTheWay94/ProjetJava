package be.bastien.metier;

import be.bastien.POJO.POJOMembre;
import be.bastien.POJO.POJOVehicule;

public class Vehicule {
	private POJOVehicule pojoVehicule;
	
	public Vehicule(POJOVehicule pojoVehicule) {
		this.pojoVehicule = pojoVehicule;
	}
	
	public void ajouterMembre(POJOMembre membre) {
		pojoVehicule.addMembre(membre);
	}
	
	public void retirerPlaceVehicule() {
		int placeMembre = pojoVehicule.getPlaceLibreMembre();
		placeMembre--;
		pojoVehicule.setPlaceLibreMembre(placeMembre);
	}
	
	public void ajouterPlaceVehicule() {
		int placeMembre = pojoVehicule.getPlaceLibreMembre();
		placeMembre++;
		pojoVehicule.setPlaceLibreMembre(placeMembre);
	}
	
	public void retirerPlaceVelo() {
		int placeVelo = pojoVehicule.getPlaceLibreVelo();
		placeVelo--;
		pojoVehicule.setPlaceLibreMembre(placeVelo);
	}
	
	public void ajouterPlaceVelo() {
		int placeVelo = pojoVehicule.getPlaceLibreVelo();
		placeVelo++;
		pojoVehicule.setPlaceLibreMembre(placeVelo);
	}
}
