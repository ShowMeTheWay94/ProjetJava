package be.bastien.metier;

import java.util.GregorianCalendar;

import be.bastien.POJO.*;

public class Responsable extends Personne{
	private POJOResponsable pojoResponsable;
	
	public Responsable(POJOResponsable pojoResponsable, POJOPersonne pojoPersonne) {
		super(pojoPersonne);
		this.pojoResponsable = pojoResponsable;
	}
	
	public void modifierDateExp(GregorianCalendar dateExp) {
		pojoResponsable.setDateExpiration(dateExp);
	}
}
