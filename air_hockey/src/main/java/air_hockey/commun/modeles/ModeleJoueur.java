package air_hockey.commun.modeles;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.monde2d.MondeAirHockey2d;
import air_hockey.frontal.donnees.DonneesVuePartie;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.models.Model;

public class ModeleJoueur implements Model{

	private MondeAirHockey2d mondeAirHockey2d = new MondeAirHockey2d();
	
	private String premierJoueur = "Yourrage";
	private String deuxiemeJoueur = "Bruce";
	
	private int scorePremierJoueur = 0;
    private int scoreDeuxiemeJoueur = 0;
	
	public void afficherInfoPartieSur(VuePartie vuePartie) {
		
		vuePartie.afficherPremierJoueur(premierJoueur);
        vuePartie.afficherDeuxiemeJoueur(deuxiemeJoueur);

        vuePartie.afficherScorePremierJoueur(String.valueOf(scorePremierJoueur));
        vuePartie.afficherScoreDeuxiemeJoueur(String.valueOf(scoreDeuxiemeJoueur));
	}
	
	public void copierDonneesDans(DonneesVuePartie donneesVuePartie) {
		donneesVuePartie.copierDonnesDe(mondeAirHockey2d);
	}
	
	public void copierDonnesDe(MondeAirHockey2d mondeAirHockey2d) {
		this.mondeAirHockey2d.copyDataFrom(mondeAirHockey2d);
	}
	
	public void ajouterPointPour(Cadran cadran) {
		switch(cadran) {
        case GAUCHE:
        default:
            scorePremierJoueur++;
            break;

        case DROITE:
            scoreDeuxiemeJoueur++;
            break;
        }
	}
}
