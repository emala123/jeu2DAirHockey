package air_hockey.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import air_hockey.commun.messages.MsgAjouterJoueur;
import air_hockey.commun.messages.MsgRetirerJoueur;
import air_hockey.commun.modeles.ModeleLeaderboard;
import ca.ntro.app.tasks.backend.BackendTasks;

public class ModifierLeaderboard {

	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierLeaderboard").waitsFor(model(ModeleLeaderboard.class)).andContains(subTasks -> {
			
			ajouterJoueur(subTasks);
			
			retirerJoueur(subTasks);
			
		});
	}
	
	private static void ajouterJoueur(BackendTasks subTasks) {
		
		subTasks.task("ajouterJoueur").waitsFor(message(MsgAjouterJoueur.class)).thenExecutes(inputs -> {
			
			MsgAjouterJoueur msgAjouterJoueur = inputs.get(message(MsgAjouterJoueur.class));
			ModeleLeaderboard leaderboard = inputs.get(model(ModeleLeaderboard.class));
			
			msgAjouterJoueur.ajouterA(leaderboard);
		});
	}
	
	private static void retirerJoueur(BackendTasks subTasks) {
		subTasks.task("retirerPosition").waitsFor(message(MsgRetirerJoueur.class))
		
		.thenExecutes(inputs -> {
			
			MsgRetirerJoueur msgRetirerJoueur = inputs.get(message(MsgRetirerJoueur.class));
			ModeleLeaderboard leaderboard = inputs.get(model(ModeleLeaderboard.class));
			
			msgRetirerJoueur.retirerDe(leaderboard);
		});
	}
}
