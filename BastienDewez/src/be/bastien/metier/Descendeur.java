package be.bastien.metier;

import be.bastien.POJO.*;

public class Descendeur extends Vtt {
	private POJODescendeur pojoDescendeur;
	
	public Descendeur(POJODescendeur pojoDescendeur, POJOVtt pojoVtt, POJOCategorie pojoCategorie) {
		super(pojoVtt, pojoCategorie);
		this.pojoDescendeur = pojoDescendeur;
	}
	
	public void modifierSuspension(String typeSuspension) {
		pojoDescendeur.setTypeSuspension(typeSuspension);
	}
}
