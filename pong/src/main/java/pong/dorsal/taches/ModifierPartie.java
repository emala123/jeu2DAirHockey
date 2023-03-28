package pong.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.messages.MsgAjouterPoint;
import pong.commun.modeles.ModelePartie;

public class ModifierPartie {

    public static void creerTaches(BackendTasks tasks) {

        tasks.taskGroup("ModifierPartie")

             .waitsFor(model(ModelePartie.class))

              .contains(subTasks -> {

                    ajouterPoint(subTasks);

              });
    }

    private static void ajouterPoint(BackendTasks tasks) {

        tasks.task("ajouterPoint")

             .waitsFor(message(MsgAjouterPoint.class))

             .thenExecutes(inputs -> {

                 MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class));
                 ModelePartie    partie          = inputs.get(model(ModelePartie.class));

                 msgAjouterPoint.copierDonneesDans(partie);
                 msgAjouterPoint.ajouterPointA(partie);

             });
    }

}