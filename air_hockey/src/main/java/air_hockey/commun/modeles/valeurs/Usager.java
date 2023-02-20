package air_hockey.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;

public class Usager implements ModelValue{

	private String id;
	private String prenom;
	private String nom;
	private int pointage;
	
	public Usager() {
		
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

	public int getPointage() {
		return pointage;
	}

	public void setPointage(int pointage) {
		this.pointage = pointage;
	}

	    @Override
	    public String toString() {
	        return nomComplet();
	    }

	    public String nomComplet() {
	        return prenom + " " + nom + " " +pointage;
	    }

	

	
	
}
