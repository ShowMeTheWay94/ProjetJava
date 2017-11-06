package be.bastien.metier;

import be.bastien.POJO.POJOCategorie;
import be.bastien.POJO.POJOMembre;

public class Categorie {
	private POJOCategorie pojoCategorie;
	
	public Categorie(POJOCategorie pojoCategorie) {
		this.pojoCategorie = pojoCategorie;
	}
	
	public void ajouterMembre(POJOMembre membre) {
		pojoCategorie.addMembre(membre);
	}
}
