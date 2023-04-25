package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.commun.modeles.ModeleJoueur;
import air_hockey.frontal.donnees.DonneesVuePartie;
import air_hockey.frontal.evenements.EvtActionJoueur;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;
import ca.ntro.core.task_graphs.task_graph.Task;

public class AfficherPartie {
	
	private static Task premiereTache = null;

	public static void creerTaches(FrontendTasks tasks, String idLeaderboard) {
		
		premiereTache = creerDonneesVuePartie(tasks, idLeaderboard);
		
		tasks.taskGroup("AfficherPartie")
		
			.waitsFor(created(DonneesVuePartie.class))
		
			.andContains(subTasks -> {
				
				prochaineImagePartie(subTasks);
				
				observerModeleJoueur(subTasks, idLeaderboard);
				
				reagirActionJoueur(subTasks,idLeaderboard);
		});
	}
	
	public static void supprimerTaches() {
		if(premiereTache != null) {
			premiereTache.removeFromGraph();
		}
	}
	
	private static Task creerDonneesVuePartie(FrontendTasks tasks, String idLeaderboard) {
		
		return tasks.task(create(DonneesVuePartie.class))
			
			.waitsFor("Initialisation")
			
			.executesAndReturnsCreatedValue(inputs -> {
				
				return new DonneesVuePartie();
				
			}).getTask();
	}
	
	private static void prochaineImagePartie(FrontendTasks subTasks) {

		subTasks.task("prochaineImagePartie")
		
			.waitsFor(clock().nextTick())
		
			.thenExecutes(inputs -> {
					
				Tick tick = inputs.get(clock().nextTick());
     			DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
     			VuePartie vuePartie = inputs.get(created(VuePartie.class));

     			donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
     			donneesVuePartie.afficherSur(vuePartie);

       });
    }
	
	private static void observerModeleJoueur(FrontendTasks subTasks, String idLeaderboard) {
		
		subTasks.task("observerModeleJoueur")
			
			.waitsFor(modified(ModeleJoueur.class, idLeaderboard))
			
			.thenExecutes(inputs -> {
				
				VuePartie vuePartie = inputs.get(created(VuePartie.class));
				DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
				Modified<ModeleJoueur> modifiedPartie = inputs.get(modified(ModeleJoueur.class, idLeaderboard));
				
				ModeleJoueur modeleJoueur = modifiedPartie.currentValue();
				
				modeleJoueur.afficherInfoPartieSur(vuePartie);
				modeleJoueur.copierDonneesDans(donneesVuePartie);
			});
	}
	
	private static void reagirActionJoueur(FrontendTasks subTasks, String idLeaderboard) {
		
		subTasks.task("reagirActionJoueur")
			
			.waitsFor(event(EvtActionJoueur.class))
			
			.thenExecutes(inputs -> {
				
				DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
				EvtActionJoueur evtActionJoueur = inputs.get(event(EvtActionJoueur.class));
				
				evtActionJoueur.appliquerA(donneesVuePartie);
		});
	}
}
