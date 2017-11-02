package be.bastien.metier;

import be.bastien.POJO.*;

public class Tresorier extends Personne {
	private POJOTresorier pojoTresorier;
	
	public Tresorier(POJOTresorier pojoTresorier, POJOPersonne pojoPersonne) {
		super(pojoPersonne);
		this.pojoTresorier = pojoTresorier;
	}
}
