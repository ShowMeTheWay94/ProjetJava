package be.bastien.POJO;

import java.io.Serializable;
import java.util.List;

public class POJOTresorier extends POJOPersonne implements Serializable {
	private static final long serialVersionUID = 303556501633655016L;

	//Variable d'instance
	private List<POJOMembre> listMembre;
	private int numCompteCourant;
	
	//Constructeur
	public POJOTresorier() {
		super();
	}

	//Getters et Setters
	public List<POJOMembre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<POJOMembre> listMembre) {
		this.listMembre = listMembre;
	}

	public int getNumCompteCourant() {
		return numCompteCourant;
	}

	public void setNumCompteCourant(int numCompteCourant) {
		this.numCompteCourant = numCompteCourant;
	}
	
	public void addMembre(POJOMembre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(POJOMembre membre){
		this.listMembre.remove(membre);
	}
}
