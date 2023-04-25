package air_hockey.commun.valeurs;

import java.util.Locale;

import air_hockey.frontal.fragment.FragmentPosition;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;

public class position implements ModelValue{
	
	private String idPosition;
	private Joueur joueur;
	
	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur Joueur) {
		this.joueur = Joueur;
	}

	public String getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(String idPosition) {
		this.idPosition = idPosition;
	}
	@Override
	public String toString() {
		return joueur.toString();
	}
	public position() {
		super();
	}
	
	public position(String idPosition, Joueur joueur) {
		setIdPosition(idPosition);
		setJoueur(joueur);
		
	}
	
	public FragmentPosition creerFragment(ViewLoader<FragmentPosition> viewLoaderPosition) {
		return viewLoaderPosition.createView();
	}
	
	public void afficherSur(FragmentPosition fragmentPosition) {
		
		Locale langueLocale = Locale.getDefault();
		String langueString = langueLocale.getLanguage();
		
		if (joueur.getPoint() > 1){
			if(langueString == "fr") {
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " points!");
			}else if(langueString == "en") {
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " points!");
			}else if(langueString == "es"){
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " puntos!");
			}
		}else {
			if(langueString == "fr") {
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " point!");
			}else if(langueString == "en") {
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " point!");
			}else if(langueString == "es"){
				fragmentPosition.afficherDescriptionJoueur(joueur.getRegion() + ": " + joueur.getPrenom() + " " + joueur.getNom() + " - " + joueur.getPoint() + " punto!");
			}
		}
		
		fragmentPosition.memoriserIdPosition(idPosition);
	}
}
