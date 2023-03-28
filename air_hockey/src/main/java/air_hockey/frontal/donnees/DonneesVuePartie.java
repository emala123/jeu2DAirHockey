package air_hockey.frontal.donnees;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;

public class DonneesVuePartie implements ViewData {

	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;

	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;
	
	private MondeAir_Hockey2d mondeAir_Hockey2d = new MondeAir_Hockey2d();
	private String fpsCourant = "0";

	public void afficherSur(VuePartie vuePartie) {

		calculerFpsSiNecessaire();

		vuePartie.viderCanvas();
		vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
		vuePartie.afficherAir_Hockey2d(mondeAir_Hockey2d);

		imagesAfficheesDepuisDernierCalculFps++;

	}

	private void calculerFpsSiNecessaire() {
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

		if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);

			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
	}

	// ajouter la méthode
	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
	}

	 public void reagirTempsQuiPasse(double elapsedTime) {
	        mondeAir_Hockey2d.onTimePasses(elapsedTime);
	    }
	 
	 public void copierDonnesDe(MondeAir_Hockey2d mondeAir_Hockey2d) {
		 mondeAir_Hockey2d.copyDataFrom(mondeAir_Hockey2d);
	    }

	 public void appliquerActionJoueur(Cadran cadran, Action action) {
		 mondeAir_Hockey2d.appliquerActionJoueur(cadran, action);
	    }
	 
}