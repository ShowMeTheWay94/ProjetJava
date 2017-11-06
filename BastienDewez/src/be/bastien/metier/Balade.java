package be.bastien.metier;

import be.bastien.POJO.POJOBalade;
import be.bastien.POJO.POJOVehicule;

public class Balade {
	private POJOBalade pojoBalade;
	
	public Balade(POJOBalade pojoBalade) {
		this.pojoBalade = pojoBalade;
	}
	
	public void ajouterVehicule(POJOVehicule vehicule) {
		pojoBalade.addVehicule(vehicule);
	}
	
	public void calculerForfait() {
		
	}
}
