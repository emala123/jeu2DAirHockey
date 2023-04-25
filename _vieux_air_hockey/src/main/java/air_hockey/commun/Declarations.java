package air_hockey.commun;

import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.messages.MsgAjouterPoint;
import air_hockey.commun.messages.MsgRetirerPartie;
import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.ModelePartie;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import air_hockey.commun.monde2d.Poussoir2d;
import air_hockey.commun.monde2d.Puck2d;
import air_hockey.commun.valeurs.Historique;
import air_hockey.commun.valeurs.Usager;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterPartie.class);
		registrar.registerMessage(MsgAjouterPoint.class);
		registrar.registerMessage(MsgRetirerPartie.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleHistorique.class);
		registrar.registerValue(Usager.class);
		registrar.registerValue(Historique.class);
		registrar.registerModel(ModelePartie.class);
		registrar.registerValue(MondeAir_Hockey2d.class);
		registrar.registerValue(Puck2d.class);
		registrar.registerValue(Poussoir2d.class);
	}

	 public static void declarerServeur(ServerRegistrar registrar) {
	        // ajouter
	        registrar.registerName("localhost");

	        // ajouter
	        registrar.registerPort(8002);
	    }

}
