package pong.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;

public class RendezVous implements ModelValue {

	private String idRendezVous;
    private Usager premierJoueur;
	
	 public RendezVous(){
	    }

	public String getIdRendezVous() {
		return idRendezVous;
	}

	public void setIdRendezVous(String idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public Usager getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Usager premierJoueur) {
		this.premierJoueur = premierJoueur;
	}
	
	 @Override
	    public String toString() {
	        return premierJoueur.toString();
	    }
	
}