package pong.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Initialisation")

				.andContains(subTasks ->{
					
					creerVueRacine(subTasks);
					
					installerVueRacine(subTasks);
					
					creerVueFileAttente(subTasks);
					
					installerVueFileAttente(subTasks);
					
					
					afficherFenetre(subTasks);
					
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

    private static void creerVueFileAttente(FrontendTasks tasks) {

        tasks.task(create(VueFileAttente.class))

             .waitsFor(viewLoader(VueFileAttente.class))
             
          // ajouter
             .waitsFor(viewLoader(FragmentRendezVous.class))

             // ajouter
             .waitsFor(viewLoader(FragmentPartieEnCours.class))
             
             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueFileAttente> viewLoader = inputs.get(viewLoader(VueFileAttente.class));

                 ViewLoader<FragmentRendezVous>    viewLoaderRendezVous    = inputs.get(viewLoader(FragmentRendezVous.class));
                 ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours = inputs.get(viewLoader(FragmentPartieEnCours.class));	
                 
                 VueFileAttente vueFileAttente = viewLoader.createView();
                 
                 vueFileAttente.setViewLoaderRendezVous(viewLoaderRendezVous);
                 vueFileAttente.setViewLoaderPartieEnCours(viewLoaderPartieEnCours);
                 
                 return vueFileAttente;
             });
    }

    private static void installerVueFileAttente(FrontendTasks tasks) {

        tasks.task("installerVueFileAttente")

              .waitsFor(created(VueRacine.class))

              .waitsFor(created(VueFileAttente.class))

              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
                  
                  vueRacine.afficherSousVue(vueFileAttente);

              });
    }
    
}
