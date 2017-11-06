package be.bastien.metier;

import be.bastien.POJO.*;

public class Vtt extends Categorie{
	private POJOVtt pojoVtt;
	
	public Vtt(POJOVtt pojoVtt, POJOCategorie pojoCategorie) {
		super(pojoCategorie);
		this.pojoVtt = pojoVtt;
	}
	
	public void modifierRoue(String typeRoue) {
		pojoVtt.setTypeRoue(typeRoue);
	}
}
