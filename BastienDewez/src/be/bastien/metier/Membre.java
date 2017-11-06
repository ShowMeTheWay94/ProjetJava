package be.bastien.metier;

import be.bastien.POJO.*;

public class Membre extends Personne {
	private POJOMembre pojoMembre;
	
	public Membre(POJOMembre pojoMembre, POJOPersonne pojoPersonne) {
		super(pojoPersonne);
		this.pojoMembre = pojoMembre;
	}
	
	public void payerCotisation() {
		pojoMembre.setCotisation(0);
		pojoMembre.setStatutCotisation("Pay�");
	}
}
