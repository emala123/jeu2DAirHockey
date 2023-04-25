package air_hockey.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import air_hockey.commun.modeles.ModelePartie;
import air_hockey.frontal.donnees.DonneesVuePartie;
import air_hockey.frontal.evenements.EvtActionJoueur;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;

public class AfficherPartie {

	public static void creerTaches(FrontendTasks tasks, String idPartie) {

		creerDonneesVuePartie(tasks);

		tasks.taskGroup("AfficherPartie")

				.waitsFor(created(DonneesVuePartie.class))

				.andContains(subTasks -> {

					prochaineImagePartie(subTasks);

					observerModelePartie(subTasks, idPartie);

					reagirActionJoueur(subTasks);

				});

	}

	private static void creerDonneesVuePartie(FrontendTasks tasks) {

		tasks.task(create(DonneesVuePartie.class))

				.waitsFor("Initialisation")

				.executesAndReturnsCreatedValue(inputs -> {

					return new DonneesVuePartie();
				});
	}

	private static void reagirActionJoueur(FrontendTasks tasks) {

		tasks.task("reagirActionJoueur")

				.waitsFor(event(EvtActionJoueur.class))

				.thenExecutes(inputs -> {

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					EvtActionJoueur evtActionJoueur = inputs.get(event(EvtActionJoueur.class));

					evtActionJoueur.appliquerA(donneesVuePartie);

				});
	}

	private static void observerModelePartie(FrontendTasks tasks, String idPartie) {

		tasks.task("observerModelePartie")

				.waitsFor(modified(ModelePartie.class, idPartie))

				.thenExecutes(inputs -> {

					VuePartie vuePartie = inputs.get(created(VuePartie.class));
					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					Modified<ModelePartie> modifiedPartie = inputs.get(modified(ModelePartie.class, idPartie));

					ModelePartie modelePartie = modifiedPartie.currentValue();

					modelePartie.afficherInfoPartieSur(vuePartie);
					modelePartie.copierDonneesDans(donneesVuePartie);

				});
	}

	private static void prochaineImagePartie(FrontendTasks subTasks) {

		subTasks.task("prochaineImagePartie")

				.waitsFor(clock().nextTick())

				.thenExecutes(inputs -> {

					Tick tick = inputs.get(clock().nextTick());

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					VuePartie vuePartie = inputs.get(created(VuePartie.class));

					donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());

					// TODO: afficher le monde 2d
					donneesVuePartie.afficherSur(vuePartie);
				});
	}

}