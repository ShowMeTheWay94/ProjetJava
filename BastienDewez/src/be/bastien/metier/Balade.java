package be.bastien.metier;

import java.io.Serializable;
import java.util.List;

public class Balade implements Serializable {
	private static final long serialVersionUID = -5819423089165019003L;
	
	//Variable d'instance
	private int idBalade;
	private String nomBalade;
	private String lieuDepart;
	private String dateBalade;
	private double forfait;
	private List<Vehicule> listVehicule;
	private Categorie categorie;
	
	//Constructeur
	public Balade() { }

	//Getters et Setters
	public int getIdBalade() {
		return idBalade;
	}

	public void setIdBalade(int idBalade) {
		this.idBalade = idBalade;
	}
	
	public String getNomBalade() {
		return nomBalade;
	}

	public void setNomBalade(String nomBalade) {
		this.nomBalade = nomBalade;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getDateBalade() {
		return dateBalade;
	}

	public void setDateBalade(String dateBalade) {
		this.dateBalade = dateBalade;
	}

	public double getForfait() {
		return forfait;
	}

	public void setForfait(double forfait) {
		this.forfait = forfait;
	}

	public List<Vehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(List<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}
	
	public void addVehicule(Vehicule vehicule){
		if(!listVehicule.contains(vehicule))
			listVehicule.add(vehicule);
	}
	
	public void removeVehicule(Vehicule vehicule){
		this.listVehicule.remove(vehicule);
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public double calculerForfait(int kilometre) {
		double forfait;
		
		forfait = 0.15*kilometre;
		
		return forfait;
	}
	
	public String toString() {
		return this.getNomBalade() + " " + this.getLieuDepart() + " " + this.getDateBalade() + " " + this.getForfait();
	}
}
