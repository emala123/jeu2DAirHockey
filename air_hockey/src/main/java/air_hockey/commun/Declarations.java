package air_hockey.commun;

import air_hockey.commun.messages.MsgAjouterJoueur;
import air_hockey.commun.messages.MsgAjouterPoint;
import air_hockey.commun.messages.MsgRetirerJoueur;
import air_hockey.commun.modeles.ModeleLeaderboard;
import air_hockey.commun.modeles.ModelePartie;
import air_hockey.commun.modeles.ModeleJoueur;
import air_hockey.commun.monde2d.But2d;
import air_hockey.commun.monde2d.MondeAirHockey2d;
import air_hockey.commun.monde2d.Puck2d;
import air_hockey.commun.monde2d.Pusher2d;
import air_hockey.commun.valeurs.Joueur;
import air_hockey.commun.valeurs.position;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterJoueur.class);
		registrar.registerMessage(MsgRetirerJoueur.class);
		registrar.registerMessage(MsgAjouterPoint.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleLeaderboard.class);
		registrar.registerValue(Joueur.class);
		registrar.registerValue(position.class);
		registrar.registerModel(ModeleJoueur.class);
		registrar.registerValue(MondeAirHockey2d.class);
		registrar.registerValue(Puck2d.class);
		registrar.registerValue(Pusher2d.class);
		registrar.registerModel(ModelePartie.class);
		registrar.registerValue(But2d.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		
		registrar.registerName("localhost");
		registrar.registerPort(8002);
		
	}

}
