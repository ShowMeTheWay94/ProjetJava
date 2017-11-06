package be.bastien.metier;

import be.bastien.POJO.*;

public class Cyclo extends Categorie{
	private POJOCyclo pojoCyclo;
	
	public Cyclo(POJOCyclo pojoCyclo, POJOCategorie pojoCategorie) {
		super(pojoCategorie);
		this.pojoCyclo = pojoCyclo;
	}
	
	public void modifierPorteBidon(boolean porteBidon) {
		pojoCyclo.setPorteBidon(porteBidon);
	}
}
