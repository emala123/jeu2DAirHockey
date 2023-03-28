package pong.commun.valeurs;

import ca.ntro.app.models.ModelValue;
import pong.commun.enums.Action;
import pong.commun.enums.Cadran;
import pong.frontal.donnees.DonneesVuePartie;

public class ActionJoueur implements ModelValue {

    private Cadran cadran;
    private Action action;

    // ATTENTION: les méthodes get/set à la main

    public String getCadran() {
        return cadran.name();
    }

    public void setCadran(String cadran) {
        this.cadran = Cadran.valueOf(cadran);
    }

    public String getAction() {
    	return action.name();
    }

    public void setAction(String action) {
        this.action = Action.valueOf(action);
    }

    public ActionJoueur() {

    }

    public ActionJoueur(Cadran cadran, Action action) {
        this.cadran = cadran;
        this.action = action;
    }

    public void appliquerA(DonneesVuePartie donneesVuePartie) {
        donneesVuePartie.appliquerActionJoueur(cadran, action);
    }

	

}