package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Membre extends Personne implements Serializable {
	private static final long serialVersionUID = 7958552928958704463L;

	//Variable d'instance
	private int cotisation;
	private String statutCotisation;
	private List<Categorie> listCategorie;
	
	//Constructeur
	public Membre() { 
		super();
	}
	
	//Getters et Setters
	public int getCotisation() {
		return cotisation;
	}

	public void setCotisation(int cotisation) {
		this.cotisation = cotisation;
	}

	public String getStatutCotisation() {
		return statutCotisation;
	}

	public void setStatutCotisation(String statutCotisation) {
		this.statutCotisation = statutCotisation;
	}
	
	public List<Categorie> getCategorie() {
		return listCategorie;
	}
	
	public void setCategorie(List<Categorie> categorie) {
		this.listCategorie = categorie;
	}
	
	public void addCategorie(Categorie categorie){
		if(!listCategorie.contains(categorie))
			listCategorie.add(categorie);
	}
	
	public void removeCategorie(Categorie categorie){
		this.listCategorie.remove(categorie);
	}
}
