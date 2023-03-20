package pong.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import pong.dorsal.taches.ModifierFileAttente;


public class DorsalPong extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {

		ModifierFileAttente.creerTaches(tasks);

	}

	@Override
	public void execute() {

	}

}
