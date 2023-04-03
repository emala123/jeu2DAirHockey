package pong.maquettes;

import java.util.List;

import ca.ntro.core.initialization.Ntro;
import pong.commun.valeurs.Usager;

public class MaquetteUsagers {

    public static void prochainUsager() {
        MaquetteSession.usagerCourant = eviterRepetitionDePrenom(usagerAleatoire());
    }

    public static Usager usagerCourant () {
        return MaquetteSession.usagerCourant;
    }

    static Usager usagerAleatoire() {
        Usager usager = new Usager();

        usager.setId(idAleatoire());
        usager.setPrenom(prenomAleatoire());
        usager.setNom(nomAleatoire());

        return usager;
    }

    private static Usager eviterRepetitionDePrenom(Usager usagerAleatoire) {

        while(usagerAleatoire.getPrenom().equals(MaquetteSession.usagerCourant.getPrenom())) {

            usagerAleatoire.setPrenom(prenomAleatoire());
        }

        return usagerAleatoire;
    }

    static String idAleatoire() {
        return Ntro.random().nextId(4);
    }

    static String prenomAleatoire() {

        List<String> choixDeNoms = List.of("Alice", 
                                           "Bob", 
                                           "Chaaya", 
                                           "Dominic", 
                                           "Élisabeth", 
                                           "Firas", 
                                           "Gregson",
                                           "Mehdi",
                                           "Louis",
                                           "Marcel",
                                           "Ashwin",
                                           "Ichiro",
                                           "Jun");

        return Ntro.random().choice(choixDeNoms);
    }

    static String nomAleatoire() {

        List<String> choixDeNoms = List.of("Abdenouri", 
                                           "Ahmadi", 
                                           "Augustin", 
                                           "Chaussé", 
                                           "Delisle", 
                                           "Heer", 
                                           "Lagrois",
                                           "Daverna",
                                           "Gonzales",
                                           "Medjoubi",
                                           "Castillo",
                                           "Josan",
                                           "Yi");

        return Ntro.random().choice(choixDeNoms);
    }
}
