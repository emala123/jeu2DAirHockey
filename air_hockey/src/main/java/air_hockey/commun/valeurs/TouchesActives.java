package air_hockey.commun.valeurs;

import java.util.HashSet;
import java.util.Set;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import air_hockey.commun.enums.Touche;
import air_hockey.frontal.evenements.EvtActionJoueur;
import ca.ntro.app.NtroApp;
import ca.ntro.app.models.ModelValue;

public class TouchesActives implements ModelValue {
	
	private Set<Touche>      touches = new HashSet<>();
	
	private EvtActionJoueur evtActionJoueur = NtroApp.newEvent(EvtActionJoueur.class);

	public Set<Touche> getTouches() {
		return touches;
	}

	public void setTouches(Set<Touche> touches) {
		this.touches = touches;
	}

	public TouchesActives() {
	}

	public TouchesActives(Cadran cadran) {
		evtActionJoueur.setCadran(cadran);
	}

	public void activer(Touche touche) {
		touches.add(touche);
		
		declencherActionJoueurSelonNouvelleTouche(touche);
		
	}

	private void declencherActionJoueurSelonNouvelleTouche(Touche touche) {
		if((touche == Touche.HAUT && touches.contains(Touche.DROITE))
		   ||  (touche == Touche.DROITE && touches.contains(Touche.HAUT))){

			evtActionJoueur.setAction(Action.DIAGONALHAUTDROITE);

		} else if((touche == Touche.HAUT && touches.contains(Touche.GAUCHE))
				|| (touche == Touche.GAUCHE && touches.contains(Touche.HAUT))){

			evtActionJoueur.setAction(Action.DIAGONALHAUTGAUCHE);

		} else if((touche == Touche.BAS && touches.contains(Touche.DROITE))
				|| (touche == Touche.DROITE && touches.contains(Touche.BAS))){

			evtActionJoueur.setAction(Action.DIAGONALBASDROITE);

		} else if((touche == Touche.BAS && touches.contains(Touche.GAUCHE))
				|| (touche == Touche.GAUCHE && touches.contains(Touche.BAS))){

			evtActionJoueur.setAction(Action.DIAGONALBASGAUCHE);

		} else if(touche == Touche.HAUT){

			evtActionJoueur.setAction(Action.HAUT);

		} else if(touche == Touche.BAS){

			evtActionJoueur.setAction(Action.BAS);

		} else if(touche == Touche.DROITE){

			evtActionJoueur.setAction(Action.DROITE);

		} else if(touche == Touche.GAUCHE){

			evtActionJoueur.setAction(Action.GAUCHE);

		}
		
		evtActionJoueur.trigger();
	}

	private void declencherActionJoueurSelonTouchesActives() {

		if(touches.contains(Touche.HAUT)
				&& touches.contains(Touche.DROITE)){

			evtActionJoueur.setAction(Action.DIAGONALHAUTDROITE);

		}else if(touches.contains(Touche.HAUT)
				&& touches.contains(Touche.GAUCHE)){

			evtActionJoueur.setAction(Action.DIAGONALHAUTGAUCHE);
			
		}else if(touches.contains(Touche.BAS)
				&& touches.contains(Touche.DROITE)){

			evtActionJoueur.setAction(Action.DIAGONALBASDROITE);

		}else if(touches.contains(Touche.BAS)
				&& touches.contains(Touche.GAUCHE)){

			evtActionJoueur.setAction(Action.DIAGONALBASGAUCHE);

		}else if(touches.contains(Touche.HAUT)) {

			evtActionJoueur.setAction(Action.HAUT);

		}else if(touches.contains(Touche.BAS)) {

			evtActionJoueur.setAction(Action.BAS);

		}else if(touches.contains(Touche.DROITE)) {

			evtActionJoueur.setAction(Action.DROITE);

		}else if(touches.contains(Touche.GAUCHE)) {

			evtActionJoueur.setAction(Action.GAUCHE);

		}else {

			evtActionJoueur.setAction(Action.ARRET);
			
		}

		evtActionJoueur.trigger();
	}

	public void desactiver(Touche touche) {
		touches.remove(touche);
		
		declencherActionJoueurSelonTouchesActives();
	}
}
