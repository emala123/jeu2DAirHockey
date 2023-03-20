package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import pong.commun.modeles.ModeleFileAttente;
import pong.frontal.vues.VueFileAttente;

public class AfficherFileAttente {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("AfficherFileAttente")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

            	 afficherFileAttente(subTasks);

                 // Prêt à observer le modèle


             });
    }

    private static void afficherFileAttente(FrontendTasks tasks) {

        tasks.task("afficherFileAttente")

             .waitsFor(modified(ModeleFileAttente.class))

             .executes(inputs -> {

                 VueFileAttente              vueFileAttente = inputs.get(created(VueFileAttente.class));
                 Modified<ModeleFileAttente> fileAttente    = inputs.get(modified(ModeleFileAttente.class));

                 ModeleFileAttente ancienneFile = fileAttente.previousValue();
                 ModeleFileAttente fileCourante = fileAttente.currentValue();

                 // Prêt à afficher les rendez-vous!
                 
                 fileCourante.afficherSur(vueFileAttente);
                 
             });
    }
}