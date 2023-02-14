package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.frontal.vues.VueHistorique;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;

public class AfficherHistorique {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherHistorique")

				.waitsFor("Initialisation")

				.andContains(subTasks -> {
					
					 afficherHistorique(subTasks);
					

				});

	}
	
	 private static void afficherHistorique(FrontendTasks tasks) {

	        tasks.task("afficherHistorique")

	             .waitsFor(modified(ModeleHistorique.class))

	             .executes(inputs -> {

	            	 VueHistorique              vueHistorique = inputs.get(created(VueHistorique.class));
	                 Modified<ModeleHistorique> historique    = inputs.get(modified(ModeleHistorique.class));

	                 ModeleHistorique ancienHistorique = historique.previousValue();
	                 ModeleHistorique historiqueCourant = historique.currentValue();

	             

	             });
	    }
	
}
