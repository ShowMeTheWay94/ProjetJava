package be.bastien.POJO;

import java.io.Serializable;
import java.util.List;

public class POJOCategorie implements Serializable {
	private static final long serialVersionUID = 7742525273144891592L;
	
	//Variable d'instance
	private int idCategorie;
	private int supplement;
	private List<POJOMembre> listMembre;
	private POJOCalendrier pojoCalendrier;

	//Constructeur
	public POJOCategorie() { }

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
	
	public POJOCalendrier getPojoCalendrier() {
		return pojoCalendrier;
	}

	public void setPojoCalendrier(POJOCalendrier pojoCalendrier) {
		this.pojoCalendrier = pojoCalendrier;
	}

	public List<POJOMembre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<POJOMembre> listMembre) {
		this.listMembre = listMembre;
	}
	
	public void addMembre(POJOMembre membre){
		if(!listMembre.contains(membre))
			listMembre.add(membre);
	}
	
	public void removeMembre(POJOMembre membre){
		this.listMembre.remove(membre);
	}
}
