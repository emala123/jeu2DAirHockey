package air_hockey.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import air_hockey.commun.messages.MsgAjouterPoint;
import air_hockey.commun.modeles.ModeleJoueur;
import ca.ntro.app.tasks.backend.BackendTasks;

public class ModifierJoueur {

	public static void creerTaches(BackendTasks tasks, String idLeaderboard) {
		
		tasks.taskGroup("ModifierJoueur" + "/" + idLeaderboard)
			
			.waitsFor(model(ModeleJoueur.class, idLeaderboard))
			
			.contains(subTasks -> {
				
				ajouterPoint(subTasks, idLeaderboard);
		});
	}
	
	private static void ajouterPoint(BackendTasks tasks, String idLeaderboard) {
		
		tasks.task("ajouterPoint" + "/" + idLeaderboard)

        	.waitsFor(message(MsgAjouterPoint.class, idLeaderboard))

        	.thenExecutes(inputs -> {

        		MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class));
        		ModeleJoueur partie = inputs.get(model(ModeleJoueur.class));

        		msgAjouterPoint.copierDonneesDans(partie);
        		msgAjouterPoint.ajouterPointA(partie);

        });
	}
}
