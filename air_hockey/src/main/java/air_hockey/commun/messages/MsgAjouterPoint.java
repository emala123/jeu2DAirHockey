package air_hockey.commun.messages;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.modeles.ModeleJoueur;
import air_hockey.commun.modeles.ModelePartie;
import air_hockey.commun.monde2d.MondeAirHockey2d;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterPoint extends MessageNtro{

	private String cadran;
	private MondeAirHockey2d mondeAirHockey2d;
	
	public void ajouterPointA(ModelePartie partie) {
		partie.ajouterPointPour(Cadran.valueOf(getCadran()));
	}
	
	public void copierDonneesDans(ModelePartie partie) {
        partie.copierDonnesDe(getMondeAirHockey2d());
    }

	public MondeAirHockey2d getMondeAirHockey2d() {
		return mondeAirHockey2d;
	}

	public void setMondeAirHockey2d(MondeAirHockey2d mondeAirHockey2d) {
		this.mondeAirHockey2d = mondeAirHockey2d;
	}

	public String getCadran() {
		return cadran;
	}

	public void setCadran(String cadran) {
		this.cadran = cadran;
	}
}
