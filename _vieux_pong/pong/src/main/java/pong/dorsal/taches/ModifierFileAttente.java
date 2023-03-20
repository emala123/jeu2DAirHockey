package pong.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.modeles.ModeleFileAttente;

public class ModifierFileAttente {

    public static void creerTaches(BackendTasks tasks) {

        tasks.taskGroup("ModifierFileAttente")

             .waitsFor(model(ModeleFileAttente.class))

             .andContains(subTasks -> {

                // XXX: ajouter l'appel!
                ajouterRendezVous(subTasks);

              });
    }

    private static void ajouterRendezVous(BackendTasks subTasks) {
        subTasks.task("ajouterRendezVous")

             .waitsFor(message(MsgAjouterRendezVous.class))

             .thenExecutes(inputs -> {

                
                 // Prêt à ajouter un rendez-vous!
                 MsgAjouterRendezVous msgAjouterRendezVous = inputs.get(message(MsgAjouterRendezVous.class));
                 ModeleFileAttente    fileAttente          = inputs.get(model(ModeleFileAttente.class));

                 // Intuitivement, on veut
                 // fileAttente.ajouterRendezVous(msgAjouterRendezVous);

                 // Avec l'inversion des dépendances, on va plutôt faire:
                 msgAjouterRendezVous.ajouterA(fileAttente);
             });
    }
}