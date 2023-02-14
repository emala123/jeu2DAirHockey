package air_hockey.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.vues.VueHistorique;
import air_hockey.frontal.vues.VueRacine;
import air_hockey.frontal.taches.AfficherHistorique;
import air_hockey.frontal.taches.Initialisation;

public class FrontalAirHockey implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {

        Initialisation.creerTaches(tasks);
        AfficherHistorique.creerTaches(tasks);
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
    	registrar.registerView(VueRacine.class, "/racine.xml");
    	registrar.registerView(VueHistorique.class, "/historique.xml");
    	registrar.registerStylesheet("/dev.css");
    	//registrar.registerStylesheet("/prod.css");
    	registrar.registerDefaultResources("/chaines_fr.properties");
    	registrar.registerResources(NtroApp.locale("en"), 
                "/chaines_en.properties");
    }

    @Override
    public void execute() {

    }

}
