package air_hockey.commun.messages;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.modeles.ModelePartie;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterPoint extends MessageNtro {

    private String cadran;
    private MondeAir_Hockey2d mondeAir_Hockey2d;

    // générer les méthodes get/set

    public void ajouterPointA(ModelePartie partie) {
        partie.ajouterPointPour(Cadran.valueOf(getCadran()));
    }

    public void copierDonneesDans(ModelePartie partie) {
        partie.copierDonnesDe(getMondeAir_Hockey2d());
    }

	public MondeAir_Hockey2d getMondeAir_Hockey2d() {
		return mondeAir_Hockey2d;
	}

	public void setMondeAir_Hockey2d(MondeAir_Hockey2d mondeAir_Hockey2d) {
		this.mondeAir_Hockey2d = mondeAir_Hockey2d;
	}

	public String getCadran() {
		return cadran;
	}

	public void setCadran(String cadran) {
		this.cadran = cadran;
	}

}