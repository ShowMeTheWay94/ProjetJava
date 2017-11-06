package be.bastien.metier;

import be.bastien.POJO.POJOBalade;
import be.bastien.POJO.POJOCalendrier;

public class Calendrier {
	private POJOCalendrier pojoCalendrier;
	
	public Calendrier(POJOCalendrier pojoCalendrier) {
		this.pojoCalendrier = pojoCalendrier;
	}
	
	public void ajouterBalade(POJOBalade balade) {
		pojoCalendrier.addBalade(balade);
	}
}
