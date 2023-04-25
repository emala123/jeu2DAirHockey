package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.frontal.fragment.FragmentPosition;
import air_hockey.frontal.vues.VueAccueil;
import air_hockey.frontal.vues.VueLeaderboard;
import air_hockey.frontal.vues.VuePartie;
import air_hockey.frontal.vues.VueRacine;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("Initialisation").andContains(subTasks -> {
			
			creerVueRacine(subTasks);
			
			creerVueAccueil(subTasks);
			
			installerVueRacine(subTasks);
			
			afficherFenetre(subTasks);
			
			creerVueLeaderboard(subTasks);
			
			installerVueLeaderboard(subTasks);
			
			creerVuePartie(subTasks);
			
			
		});
	}
	
	private static void creerVueAccueil(FrontendTasks tasks) {

	    tasks.task(create(VueAccueil.class))

	         .waitsFor(viewLoader(VueAccueil.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VueAccueil> viewLoader = inputs.get(viewLoader(VueAccueil.class));

	             VueAccueil vueAccueil = viewLoader.createView();

	             return vueAccueil;
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
	 
	 private static void creerVueLeaderboard(FrontendTasks tasks) {

		    tasks.task(create(VueLeaderboard.class))

		         .waitsFor(viewLoader(VueLeaderboard.class))
		         
		         .waitsFor(viewLoader(FragmentPosition.class))

		         .thenExecutesAndReturnsValue(inputs -> {

		             ViewLoader<VueLeaderboard> viewLoaderLeaderboard = inputs.get(viewLoader(VueLeaderboard.class));

		             ViewLoader<FragmentPosition> viewLoaderPosition = inputs.get(viewLoader(FragmentPosition.class));
		             
		             VueLeaderboard vueLeaderboard = viewLoaderLeaderboard.createView();
		             
		             vueLeaderboard.setViewLoaderPosition(viewLoaderPosition);

		             return vueLeaderboard;
		         });
		}
	 
	 private static void installerVueLeaderboard(FrontendTasks tasks) {

		    tasks.task("installerVueLeaderboard")
		    
		    	  .waitsFor("installerVueRacine")

		          .waitsFor(created(VueRacine.class))

		          .waitsFor(created(VueLeaderboard.class))

		          .thenExecutes(inputs -> {

		              VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
		              VueLeaderboard vueLeaderboard = inputs.get(created(VueLeaderboard.class));

		              vueRacine.afficherSousVue(vueLeaderboard);

		          });
		}
	 

		
		private static void creerVuePartie(FrontendTasks tasks) {
			tasks.task(create(VuePartie.class)).waitsFor(viewLoader(VuePartie.class))
			
				.thenExecutesAndReturnsValue(inputs -> {
					
					ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));
					
					VuePartie vuePartie = viewLoader.createView();
					
					return vuePartie;
					
				});
		}
}
