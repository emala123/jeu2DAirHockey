package air_hockey.dorsal;

import air_hockey.dorsal.taches.ModifierHistorique;
import air_hockey.dorsal.taches.ModifierPartie;
import air_hockey.maquettes.MaquetteHistorique;
import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;

public class DorsalAirHockey extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		// TODO Auto-generated method stub
		ModifierHistorique.creerTaches(tasks);
		// ModifierPartie.creerTaches(tasks);

		// ajouter
		for (String idPartie : MaquetteHistorique.partieEnCours()) {
			ModifierPartie.creerTaches(tasks, idPartie);
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
