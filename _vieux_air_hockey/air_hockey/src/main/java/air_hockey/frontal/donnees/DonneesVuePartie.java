package air_hockey.frontal.donnees;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import air_hockey.commun.monde2d.MondeAirHockey2d;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;

public class DonneesVuePartie implements ViewData{

	private MondeAirHockey2d mondeAirHockey2d = new MondeAirHockey2d();
	private String fpsCourant = "0";
	
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
	
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;
	
	public void afficherSur(VuePartie vuePartie) {
		
		calculerFpsSiNecessaire();
		
		vuePartie.viderCanvas();
		vuePartie.afficherImagesParSecondes("FPS " + fpsCourant);
		vuePartie.afficherAirHockey2d(mondeAirHockey2d);
		
		imagesAfficheesDepuisDernierCalculFps++;
	}
	
	private void calculerFpsSiNecessaire() {
		
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;
		
		if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);
			
			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
	}
	
	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
	}

	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeAirHockey2d.onTimePasses(elapsedTime);
		
	}
	
	public void copierDonnesDe(MondeAirHockey2d mondeAirHockey2d) {
		mondeAirHockey2d.copyDataFrom(mondeAirHockey2d);
	}

	public void appliquerActionJoueur(Cadran cadran, Action action) {
		mondeAirHockey2d.appliquerActionJoueur(cadran, action);
		
	}
}
