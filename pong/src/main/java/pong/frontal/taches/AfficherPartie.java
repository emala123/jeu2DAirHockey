package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;
import pong.commun.modeles.ModelePartie;
import pong.evenements.EvtActionJoueur;
import pong.frontal.donnees.DonneesVuePartie;

import pong.frontal.vues.VuePartie;

public class AfficherPartie {

	public static void creerTaches(FrontendTasks tasks) {

		creerDonneesVuePartie(tasks);

		tasks.taskGroup("AfficherPartie")

				.waitsFor(created(DonneesVuePartie.class))

				.andContains(subTasks -> {

					prochaineImagePartie(subTasks);
					reagirActionJoueur(subTasks);
					observerModelePartie(subTasks);

				});

	}

	private static void observerModelePartie(FrontendTasks subTasks) {
		// TODO Auto-generated method stub
		subTasks.task("observerModelePartie")

				.waitsFor(modified(ModelePartie.class))

				.thenExecutes(inputs -> {

					VuePartie vuePartie = inputs.get(created(VuePartie.class));
					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					Modified<ModelePartie> modifiedPartie = inputs.get(modified(ModelePartie.class));

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

					donneesVuePartie.afficherSur(vuePartie);

					// TODO: afficher le monde 2d
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
}