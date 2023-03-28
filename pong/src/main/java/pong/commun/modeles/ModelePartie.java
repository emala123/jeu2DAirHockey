package pong.commun.modeles;

import ca.ntro.app.models.Model;
import pong.commun.enums.Cadran;
import pong.commun.monde2d.MondePong2d;
import pong.frontal.donnees.DonneesVuePartie;
import pong.frontal.vues.VuePartie;

public class ModelePartie implements Model {

    private MondePong2d mondePong2d = new MondePong2d();

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
        donneesVuePartie.copierDonnesDe(mondePong2d);
    }

    public void copierDonnesDe(MondePong2d mondePong2d) {
        this.mondePong2d.copyDataFrom(mondePong2d);
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