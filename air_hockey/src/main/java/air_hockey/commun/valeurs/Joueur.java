package air_hockey.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue{
	
	private String region;
	private String nom;
	private String prenom;
	private int point;
	
	public Joueur() {
		super();
	}
	
	public Joueur(String region, String prenom, String nom, int point) {
		setRegion(region);
		setPrenom(prenom);
		setNom(nom);
		setPoint(point);
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return nomCompletAvecPoint();
	}
	
	public String nomCompletAvecPoint() {
		
		if(point > 1) {
			return region + ": " + prenom + " " + nom + " : " + point + " points";
		}else {
			return region + ": " + prenom + " " + nom + " : " + point + " point";
		}
		
	}
	
}
