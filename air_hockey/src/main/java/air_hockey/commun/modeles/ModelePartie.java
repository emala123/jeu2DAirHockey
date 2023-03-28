package air_hockey.commun.modeles;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import air_hockey.frontal.donnees.DonneesVuePartie;
import air_hockey.frontal.vues.VuePartie;
import ca.ntro.app.models.Model;

public class ModelePartie implements Model {

    private MondeAir_Hockey2d mondeAir_Hockey2d = new MondeAir_Hockey2d();

    private String nomPremierJoueur = "Alice";
    private String nomDeuxiemeJoueur = "Bob";

    private int scorePremierJoueur = 0;
    private int scoreDeuxiemeJoueur = 0;

    // générer les méthodes get/set

    public void afficherInfoPartieSur(VuePartie vuePartie) {
        vuePartie.afficherNomPremierJoueur(nomPremierJoueur);
        vuePartie.afficherNomDeuxiemeJoueur(nomDeuxiemeJoueur);

        vuePartie.afficherScorePremierJoueur(String.valueOf(scorePremierJoueur));
        vuePartie.afficherScoreDeuxiemeJoueur(String.valueOf(scoreDeuxiemeJoueur));
    }

    public void copierDonneesDans(DonneesVuePartie donneesVuePartie) {
        donneesVuePartie.copierDonnesDe(mondeAir_Hockey2d);
    }

    public void copierDonnesDe(MondeAir_Hockey2d mondeAir_Hockey2d) {
        this.mondeAir_Hockey2d.copyDataFrom(mondeAir_Hockey2d);
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