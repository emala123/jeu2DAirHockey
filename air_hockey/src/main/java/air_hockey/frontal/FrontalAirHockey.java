package air_hockey.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import air_hockey.frontal.taches.Initialisation;

public class FrontalAirHockey implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {

        Initialisation.creerTaches(tasks);

    }

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {

    }

    @Override
    public void execute() {

    }

}
