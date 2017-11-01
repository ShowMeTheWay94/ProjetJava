package be.bastien.POJO;

import java.io.Serializable;
import java.util.List;

public class POJOCalendrier implements Serializable {
	private static final long serialVersionUID = -3175579318878452505L;
	
	//Variable d'instance
	private List<POJOBalade> listBalade;
	
	//Constructeur
	public POJOCalendrier() { }

	//Getters et Setters
	public List<POJOBalade> getListBalade() {
		return listBalade;
	}

	public void setListBalade(List<POJOBalade> listBalade) {
		this.listBalade = listBalade;
	}
	
	public void addBalade(POJOBalade balade){
		if(!listBalade.contains(balade))
			listBalade.add(balade);
	}
	
	public void removeBalade(POJOBalade balade){
		this.listBalade.remove(balade);
	}
}
