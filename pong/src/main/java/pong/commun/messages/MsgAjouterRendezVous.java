package pong.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.Usager;

public class MsgAjouterRendezVous extends MessageNtro {

    private Usager premierJoueur;

    public MsgAjouterRendezVous() {
    }

    public Usager getPremierJoueur() {
        return premierJoueur;
    }

    public void setPremierJoueur(Usager premierJoueur) {
        this.premierJoueur = premierJoueur;
    }
    public void ajouterA(ModeleFileAttente fileAttente) {

        fileAttente.ajouterRendezVous(premierJoueur);

    }
    
}