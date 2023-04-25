package air_hockey.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.donnees.DonneesVuePartie;
import air_hockey.frontal.evenements.EvtActionJoueur;
import air_hockey.frontal.evenements.EvtAfficherAccueil;
import air_hockey.frontal.evenements.EvtAfficherLeaderboard;
import air_hockey.frontal.evenements.EvtAfficherPartie;
import air_hockey.frontal.fragment.FragmentPosition;
import air_hockey.frontal.taches.AfficherLeaderboard;
import air_hockey.frontal.taches.AfficherPartie;
import air_hockey.frontal.taches.Initialisation;
import air_hockey.frontal.taches.Navigation;
import air_hockey.frontal.vues.VueAccueil;
import air_hockey.frontal.vues.VueLeaderboard;
import air_hockey.frontal.vues.VuePartie;
import air_hockey.frontal.vues.VueRacine;
import air_hockey.maquettes.MaquetteSession;

public class FrontalAir_Hockey implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		
		Initialisation.creerTaches(tasks);
		
		AfficherLeaderboard.creerTaches(tasks);
		
		Navigation.creerTaches(tasks);
		
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {

			registrar.registerEvent(EvtAfficherLeaderboard.class);

			registrar.registerEvent(EvtAfficherAccueil.class);
			
			registrar.registerEvent(EvtAfficherPartie.class);
		
			registrar.registerEvent(EvtActionJoueur.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueLeaderboard.class, "/leaderboard.xml");
		registrar.registerStylesheet("/leaderboard.css");
		
		registrar.registerView(VueAccueil.class, "/accueil.xml");
		registrar.registerView(VuePartie.class, "/partie.xml");
	
		registrar.registerDefaultResources("/leaderboard_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/leaderboard_en.properties");
		registrar.registerResources(NtroApp.locale("es"), "/leaderboard_es.properties");
	
		 registrar.registerFragment(FragmentPosition.class, "/fragment/position.xml");
		 
		 registrar.registerViewData(DonneesVuePartie.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
