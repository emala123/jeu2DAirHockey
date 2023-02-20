package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.frontal.evenements.EvtAfficherHistorique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import air_hockey.frontal.vues.VueHistorique;
import air_hockey.frontal.vues.VueMenu;
import air_hockey.frontal.vues.VueRacine;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class Navigation {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("Navigation")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

           
            	afficherVueHistorique(subTasks);

            	creerVueMenu(subTasks);
            	afficherVueMenu(subTasks);
            		             	
            		  

             });
    }
    
    private static void creerVueMenu(FrontendTasks tasks) {

        tasks.task(create(VueMenu.class))

             .waitsFor(viewLoader(VueMenu.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueMenu> viewLoader = inputs.get(viewLoader(VueMenu.class));

                 VueMenu vueMenu = viewLoader.createView();

                 return vueMenu;
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
