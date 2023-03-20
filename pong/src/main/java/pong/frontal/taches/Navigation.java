package pong.frontal.taches;

import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;
import ca.ntro.app.tasks.frontend.FrontendTasks;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")
		
		     .waitsFor("Initialisation")

		     .andContains(subTasks -> {

			     afficherVueFileAttente(subTasks);

			     afficherVuePartie(subTasks);

		     });
	}


	private static void afficherVuePartie(FrontendTasks tasks) {

		tasks.task("afficherVuePartie")
		
		     .waitsFor(created(VuePartie.class))
		
		     .waitsFor(event(EvtAfficherPartie.class))
		      
		     .thenExecutes(inputs -> {

		    	 VueRacine vueRacine = inputs.get(created(VueRacine.class));
		    	 VuePartie vuePartie = inputs.get(created(VuePartie.class));
		    	  
		    	 vueRacine.afficherSousVue(vuePartie);
		     });
	}

	private static void afficherVueFileAttente(FrontendTasks tasks) {

		tasks.task("afficherVueFileAttente")
		
		      .waitsFor(event(EvtAfficherFileAttente.class))
		      
		      .thenExecutes(inputs -> {
		    	  
		    	  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
		    	  VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
		    	  
		    	  vueRacine.afficherSousVue(vueFileAttente);

		      });
	}
}