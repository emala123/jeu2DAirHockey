package pong.evenements;

import ca.ntro.app.frontend.events.EventNtro;
import pong.commun.valeurs.ActionJoueur;
import pong.frontal.donnees.DonneesVuePartie;

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
