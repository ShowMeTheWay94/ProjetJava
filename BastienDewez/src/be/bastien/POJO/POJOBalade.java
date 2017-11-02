package be.bastien.POJO;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public class POJOBalade implements Serializable {
	private static final long serialVersionUID = -5819423089165019003L;
	
	//Variable d'instance
	private int idBalade;
	private String lieuDepart;
	private GregorianCalendar dateBalade;
	private double forfait;
	private List<POJOVehicule> listVehicule;
	
	//Constructeur
	public POJOBalade() { }

	//Getters et Setters
	public int getIdBalade() {
		return idBalade;
	}

	public void setIdBalade(int idBalade) {
		this.idBalade = idBalade;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public GregorianCalendar getDateBalade() {
		return dateBalade;
	}

	public void setDateBalade(GregorianCalendar dateBalade) {
		this.dateBalade = dateBalade;
	}

	public double getForfait() {
		return forfait;
	}

	public void setForfait(double forfait) {
		this.forfait = forfait;
	}

	public List<POJOVehicule> getListVehicule() {
		return listVehicule;
	}

	public void setListVehicule(List<POJOVehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}
	
	public void addVehicule(POJOVehicule vehicule){
		if(!listVehicule.contains(vehicule))
			listVehicule.add(vehicule);
	}
	
	public void removeVehicule(POJOVehicule vehicule){
		this.listVehicule.remove(vehicule);
	}
}
