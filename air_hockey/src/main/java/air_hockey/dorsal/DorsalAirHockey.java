package air_hockey.dorsal;

import air_hockey.dorsal.taches.ModifierHistorique;
import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;

public class DorsalAirHockey extends LocalBackendNtro{

	@Override
	public void createTasks(BackendTasks tasks) {
		// TODO Auto-generated method stub
		ModifierHistorique.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
