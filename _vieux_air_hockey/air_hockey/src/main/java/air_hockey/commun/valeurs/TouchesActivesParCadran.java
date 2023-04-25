package air_hockey.commun.valeurs;

import java.util.HashMap;
import java.util.Map;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.enums.Touche;
import ca.ntro.app.models.ModelValue;

public class TouchesActivesParCadran implements ModelValue {
	
	private Map<Cadran, TouchesActives> touchesParCadran = new HashMap<>();
	
	public TouchesActivesParCadran() {
		touchesParCadran.put(Cadran.GAUCHE, new TouchesActives(Cadran.GAUCHE));
		touchesParCadran.put(Cadran.DROITE, new TouchesActives(Cadran.DROITE));
	}

	public void activer(Cadran cadran, Touche touche) {
		touchesParCadran.get(cadran).activer(touche);
	}

	public void desactiver(Cadran cadran, Touche touche) {
		touchesParCadran.get(cadran).desactiver(touche);
	}

}
