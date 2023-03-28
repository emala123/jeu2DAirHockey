package pong.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import pong.commun.enums.Cadran;
import pong.commun.modeles.ModelePartie;
import pong.commun.monde2d.MondePong2d;

public class MsgAjouterPoint extends MessageNtro {

    private String cadran;
    private MondePong2d mondePong2d;

    // générer les méthodes get/set

    public void ajouterPointA(ModelePartie partie) {
        partie.ajouterPointPour(Cadran.valueOf(getCadran()));
    }

    public void copierDonneesDans(ModelePartie partie) {
        partie.copierDonnesDe(getMondePong2d());
    }

	public String getCadran() {
		return cadran;
	}

	public void setCadran(String cadran) {
		this.cadran = cadran;
	}

	public MondePong2d getMondePong2d() {
		return mondePong2d;
	}

	public void setMondePong2d(MondePong2d mondePong2d) {
		this.mondePong2d = mondePong2d;
	}

}