package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.commun.modeles.ModeleLeaderboard;
import air_hockey.frontal.vues.VueLeaderboard;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;

public class AfficherLeaderboard {

	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("AfficherLeaderboard").waitsFor("Initialisation").andContains(subTasks ->{
			
			//ajouter l'appel
			afficherLearderboard(subTasks);
			
		});
	}

	public static void afficherLearderboard(FrontendTasks tasks) {
	
		tasks.task("afficherLeaderboard").waitsFor(modified(ModeleLeaderboard.class)).executes(inputs -> {
		
			VueLeaderboard vueLeaderboard = inputs.get(created(VueLeaderboard.class));
			Modified<ModeleLeaderboard> leaderboard = inputs.get(modified(ModeleLeaderboard.class));
			
			ModeleLeaderboard ancienLeaderboard = leaderboard.previousValue();
			ModeleLeaderboard leaderboardCourant = leaderboard.currentValue();
		
		// Prêt à afficher les rendez-vous!
		leaderboardCourant.afficherSur(vueLeaderboard);
});
}
	
}
