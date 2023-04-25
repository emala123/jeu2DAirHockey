package air_hockey.maquettes;

import java.util.List;

import air_hockey.commun.valeurs.Usager;
import ca.ntro.core.initialization.Ntro;

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
        usager.setPointage(pointageAleatoire());
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
     static int pointageAleatoire() {
    	
    	List<Integer> choixDePointage = List.of(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
		return Ntro.random().choice(choixDePointage);
    	
    }
    
}