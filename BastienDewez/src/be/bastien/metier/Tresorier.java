package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Tresorier extends Personne implements Serializable {
	private static final long serialVersionUID = 303556501633655016L;

	//Variable d'instance
	private List<Membre> listMembre;
	private String numCompteCourant;
	
	//Constructeur
	public Tresorier() {
		super();
	}

	//Getters et Setters
	public List<Membre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<Membre> listMembre) {
		this.listMembre = listMembre;
	}

	public String getNumCompteCourant() {
		return numCompteCourant;
	}

	public void setNumCompteCourant(String numCompteCourant) {
		this.numCompteCourant = numCompteCourant;
	}
	
	public void addMembre(Membre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(Membre membre){
		this.listMembre.remove(membre);
	}
}
