package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Categorie implements Serializable {
	private static final long serialVersionUID = 7742525273144891592L;
	
	//Variable d'instance
	private int idCategorie;
	private int supplement;
	private List<Membre> listMembre;
	private Calendrier pojoCalendrier;

	//Constructeur
	public Categorie() { }

	//Getters et Setters
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getSupplement() {
		return supplement;
	}

	public void setSupplement(int supplement) {
		this.supplement = supplement;
	}
	
	public Calendrier getPojoCalendrier() {
		return pojoCalendrier;
	}

	public void setPojoCalendrier(Calendrier pojoCalendrier) {
		this.pojoCalendrier = pojoCalendrier;
	}

	public List<Membre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<Membre> listMembre) {
		this.listMembre = listMembre;
	}
	
	public void addMembre(Membre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(Membre membre){
		this.listMembre.remove(membre);
	}
}
