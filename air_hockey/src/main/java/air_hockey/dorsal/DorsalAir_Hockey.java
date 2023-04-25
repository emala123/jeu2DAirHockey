package air_hockey.dorsal;

import air_hockey.commun.maquettes.MaquetteLeaderboard;
import air_hockey.dorsal.taches.ModifierLeaderboard;
import air_hockey.dorsal.taches.ModifierPartie;
import air_hockey.dorsal.taches.ModifierJoueur;
import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;

public class DorsalAir_Hockey extends LocalBackendNtro{

	@Override
	public void createTasks(BackendTasks tasks) {
		ModifierLeaderboard.creerTaches(tasks);
		ModifierPartie.creerTaches(tasks);
		
		for(String idLeaderboard: MaquetteLeaderboard.partieEnCours()) {
			ModifierJoueur.creerTaches(tasks, idLeaderboard);
			
		}
		
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
