package air_hockey.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.vues.VuePartie;
import air_hockey.frontal.fragments.FragmentPartie;
import air_hockey.frontal.vues.VueHistorique;
import air_hockey.frontal.vues.VueMenu;
import air_hockey.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Initialisation")

				.andContains(subTasks ->{
					
					creerVueRacine(subTasks);
					
					installerVueRacine(subTasks);
					
					creerVueHistorique(subTasks);
					
					installerVueHistorique(subTasks);
					
					
					afficherFenetre(subTasks);
					
					creerVueMenu(subTasks);
					
					creerVuePartie(subTasks);
	            	
					
					
				});
		
	}

	 private static void creerVuePartie(FrontendTasks tasks) {

	        tasks.task(create(VuePartie.class))

	             .waitsFor(viewLoader(VuePartie.class))

	             .thenExecutesAndReturnsValue(inputs -> {
	                 
	                 ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));
	                 
	                 VuePartie vuePartie = viewLoader.createView();

	                 return vuePartie;
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
	
	private static void afficherFenetre(FrontendTasks subTasks) {

		subTasks.task("afficherFenetre")

				.waitsFor(window())

				.thenExecutes(inputs -> {

					Window window = inputs.get(window());

					window.show();
				});
	}
	
    private static void creerVueRacine(FrontendTasks tasks) {

        tasks.task(create(VueRacine.class))

             .waitsFor(viewLoader(VueRacine.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

                 VueRacine vueRacine = viewLoader.createView();

                 return vueRacine;
             });
    }

    private static void installerVueRacine(FrontendTasks tasks) {

        tasks.task("installerVueRacine")

              .waitsFor(window())

              .waitsFor(created(VueRacine.class))

              .thenExecutes(inputs -> {

                  VueRacine vueRacine = inputs.get(created(VueRacine.class));
                  Window    window    = inputs.get(window());

                  window.installRootView(vueRacine);
              });
    }

    private static void creerVueHistorique(FrontendTasks tasks) {

        tasks.task(create(VueHistorique.class))

             .waitsFor(viewLoader(VueHistorique.class))
             
          // ajouter
             .waitsFor(viewLoader(FragmentPartie.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueHistorique> viewLoader = inputs.get(viewLoader(VueHistorique.class));
                 
                 ViewLoader<FragmentPartie>    viewLoaderPartie    = inputs.get(viewLoader(FragmentPartie.class));
                 
                 VueHistorique vueHistorique = viewLoader.createView();
                 
                 vueHistorique.setViewLoaderPartie(viewLoaderPartie);
                 
                 return vueHistorique;
             });
    }

    private static void installerVueHistorique(FrontendTasks tasks) {

        tasks.task("installerVueHistorique")

              .waitsFor(created(VueRacine.class))

              .waitsFor(created(VueHistorique.class))

              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueHistorique vueHistorique = inputs.get(created(VueHistorique.class));

                  vueRacine.afficherSousVue(vueHistorique);

              });
    }
    
   
    
}
