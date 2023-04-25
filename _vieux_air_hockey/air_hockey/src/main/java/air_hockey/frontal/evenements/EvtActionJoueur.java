package air_hockey.frontal.evenements;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import air_hockey.frontal.donnees.DonneesVuePartie;
import ca.ntro.app.frontend.events.EventNtro;

public class EvtActionJoueur extends EventNtro{
	
	private Cadran cadran;
	private Action action;

	public Cadran getCadran() {
		return cadran;
	}

	public void setCadran(Cadran cadran) {
		this.cadran = cadran;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public EvtActionJoueur() {
		
	}

	public void appliquerA(DonneesVuePartie donneesVuePartie) {
		donneesVuePartie.appliquerActionJoueur(cadran, action);
	}
}
