package air_hockey.frontal.evenements;

import air_hockey.commun.valeurs.ActionJoueur;
import air_hockey.frontal.donnees.DonneesVuePartie;
import ca.ntro.app.frontend.events.EventNtro;

public class EvtActionJoueur extends EventNtro {

    private ActionJoueur action;

    // générer les méthodes get/set

    public EvtActionJoueur() {
    }

    public void appliquerA(DonneesVuePartie donneesVuePartie) {
        getAction().appliquerA(donneesVuePartie);
    }

	public ActionJoueur getAction() {
		return action;
	}

	public void setAction(ActionJoueur action) {
		this.action = action;
	}

}