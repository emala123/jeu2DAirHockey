package pong.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;

public class Usager implements ModelValue {


    private String id;
    private String prenom;
    private String nom;
	
	public Usager(){
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}