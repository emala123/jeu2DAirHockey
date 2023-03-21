package air_hockey.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.vues.VueHistorique;
import air_hockey.frontal.vues.VueMenu;
import air_hockey.frontal.vues.VueRacine;
import air_hockey.frontal.evenements.EvtAfficherHistorique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import air_hockey.frontal.fragments.FragmentPartie;
import air_hockey.frontal.taches.AfficherHistorique;
import air_hockey.frontal.taches.Initialisation;
import air_hockey.frontal.taches.Navigation;

public class FrontalAirHockey implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {

        Initialisation.creerTaches(tasks);
        AfficherHistorique.creerTaches(tasks);
        Navigation.creerTaches(tasks);
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherHistorique.class);
		registrar.registerEvent(EvtAfficherMenuPrincipal.class);
    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
    	registrar.registerView(VueRacine.class, "/racine.xml");
    	registrar.registerView(VueHistorique.class, "/historique.xml");
    	registrar.registerView(VueMenu.class, "/menu.xml");
    	registrar.registerStylesheet("/dev.css");
    	//registrar.registerStylesheet("/prod.css");
    	registrar.registerDefaultResources("/chaines_fr.properties");
    	registrar.registerResources(NtroApp.locale("en"), 
                "/chaines_en.properties");
    	registrar.registerResources(NtroApp.locale("es"), 
                "/chaines_es.properties");
    	registrar.registerResources(NtroApp.locale("de"), 
                "/chaines_de.properties");
    	registrar.registerFragment(FragmentPartie.class, "/air_hockey/fragments/parties.xml");
    }

    @Override
    public void execute() {

    }

}
