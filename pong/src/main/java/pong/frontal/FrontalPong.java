package pong.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.taches.Initialisation;
import pong.frontal.taches.AfficherFileAttente;
import pong.frontal.taches.Navigation;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;


public class FrontalPong implements FrontendFx {
	
	@Override
	public void createTasks(FrontendTasks tasks) {
		
		Initialisation.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherFileAttente.creerTaches(tasks);

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherFileAttente.class);
		registrar.registerEvent(EvtAfficherPartie.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		
		registrar.registerStylesheet("/dev.css");
		//registrar.registerStylesheet("/prod.css");
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		registrar.registerView(VuePartie.class, "/partie.xml");
		registrar.registerFragment(FragmentRendezVous.class, "/fragments/rendez_vous.xml");
        registrar.registerFragment(FragmentPartieEnCours.class, "/fragments/partie_en_cours.xml");
	}

	@Override
	public void execute() {

	}

}
