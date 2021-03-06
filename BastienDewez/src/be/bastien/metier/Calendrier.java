package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Calendrier implements Serializable {
	private static final long serialVersionUID = -3175579318878452505L;
	
	//Variable d'instance
	private List<Balade> listBalade;
	
	//Constructeur
	public Calendrier() { }

	//Getters et Setters
	public List<Balade> getListBalade() {
		return listBalade;
	}

	public void setListBalade(List<Balade> listBalade) {
		this.listBalade = listBalade;
	}
	
	public void addBalade(Balade balade){
		if(!listBalade.contains(balade))
			listBalade.add(balade);
	}
	
	public void removeBalade(Balade balade){
		this.listBalade.remove(balade);
	}
}
