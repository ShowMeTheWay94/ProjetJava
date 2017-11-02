package be.bastien.metier;

import be.bastien.POJO.*;

public class Responsable extends Personne{
	private POJOResponsable pojoResponsable;
	
	public Responsable(POJOResponsable pojoResponsable, POJOPersonne pojoPersonne) {
		super(pojoPersonne);
		this.pojoResponsable = pojoResponsable;
	}
}
