package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.frontal.evenements.EvtAfficherAccueil;
import air_hockey.frontal.evenements.EvtAfficherLeaderboard;
import air_hockey.frontal.evenements.EvtAfficherPartie;
import air_hockey.frontal.vues.VueAccueil;
import air_hockey.frontal.vues.VueLeaderboard;
import air_hockey.frontal.vues.VuePartie;
import air_hockey.frontal.vues.VueRacine;
import air_hockey.maquettes.MaquetteSession;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Navigation").waitsFor("Initialisation").andContains(subTasks->{
			
			afficherVueLeaderboard(subTasks);
			
			afficherVueAccueil(subTasks);
			
			afficherVuePartie(subTasks, tasks);
		});
	}

	private static void afficherVueAccueil(FrontendTasks tasks) {

	    tasks.task("afficherVueAccueil")

	         .waitsFor(created(VueAccueil.class))

	         .waitsFor(event(EvtAfficherAccueil.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VueAccueil vueAccueil = inputs.get(created(VueAccueil.class));

	             vueRacine.afficherSousVue(vueAccueil);
	             
	             AfficherPartie.supprimerTaches();
	         });
	}

	private static void afficherVueLeaderboard(FrontendTasks tasks) {

	    tasks.task("afficherVueLeaderboard")

	          .waitsFor(event(EvtAfficherLeaderboard.class))

	          .thenExecutes(inputs -> {

	              VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
	              VueLeaderboard vueLeaderboard = inputs.get(created(VueLeaderboard.class));

	              vueRacine.afficherSousVue(vueLeaderboard);

	          });
	}
	
	private static void afficherVuePartie(FrontendTasks subTasks, FrontendTasks tasks) {
		
		subTasks.task("afficherVuePartie")
		
			.waitsFor(created(VuePartie.class))
			
			.waitsFor(event(EvtAfficherPartie.class))
			
			.thenExecutes(inputs -> {
				
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VuePartie vuePartie = inputs.get(created(VuePartie.class));
				
				vueRacine.afficherSousVue(vuePartie);
				
				AfficherPartie.creerTaches(tasks, MaquetteSession.regionCourant());
			});
		
	}

}
