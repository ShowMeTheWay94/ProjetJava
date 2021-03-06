package be.bastien.metier;

import java.io.Serializable;

public class Personne implements Serializable {
	private static final long serialVersionUID = 8270145651619249472L;
	
	//Variable d'instance
	private int idPersonne;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	//Constructeur
	public Personne() { }

	
	//Getters et Setters
	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
