	package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.frontal.evenements.EvtAfficherHistorique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import air_hockey.frontal.vues.VueHistorique;
import air_hockey.frontal.vues.VueMenu;
import air_hockey.frontal.vues.VueRacine;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.evenements.EvtAfficherPartie;
import air_hockey.frontal.vues.VuePartie;

public class Navigation {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("Navigation")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

           
            	afficherVueHistorique(subTasks);

            	
            	afficherVueMenu(subTasks);
            		             	
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

    private static void afficherVueMenu(FrontendTasks tasks) {

        tasks.task("afficherVueMenu")

             .waitsFor(created(VueMenu.class))

             .waitsFor(event(EvtAfficherMenuPrincipal.class))

             .thenExecutes(inputs -> {

                 VueRacine vueRacine = inputs.get(created(VueRacine.class));
                 VueMenu vueMenu = inputs.get(created(VueMenu.class));

                 vueRacine.afficherSousVue(vueMenu);
             });
    }

    private static void afficherVueHistorique(FrontendTasks tasks) {

        tasks.task("afficherVueHistorique")

              .waitsFor(event(EvtAfficherHistorique.class))

              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueHistorique vueHistorique= inputs.get(created(VueHistorique.class));

                  vueRacine.afficherSousVue(vueHistorique);

              });
    }
    
}
