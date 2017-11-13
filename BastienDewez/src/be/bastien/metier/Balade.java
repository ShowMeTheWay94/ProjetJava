package be.bastien.metier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Balade implements Serializable {
	private static final long serialVersionUID = -5819423089165019003L;
	
	//Variable d'instance
	private int idBalade;
	private String nomBalade;
	private String lieuDepart;
	private Date dateBalade;
	private double forfait;
	private List<Vehicule> listVehicule;
	
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

	public Date getDateBalade() {
		return dateBalade;
	}

	public void setDateBalade(Date dateBalade) {
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
	
	public void calculerForfait() {
		
	}
	
	public String toString() {
		return getNomBalade() + " " + getLieuDepart() + " " + getDateBalade() + " " + getForfait();
	}
}
