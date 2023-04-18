package air_hockey.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import air_hockey.commun.messages.MsgAjouterPoint;
import air_hockey.commun.modeles.ModelePartie;
import ca.ntro.app.tasks.backend.BackendTasks;

public class ModifierPartie {

    public static void creerTaches(BackendTasks tasks, String idPartie) {

        tasks.taskGroup("ModifierPartie" +"/" + idPartie)

             .waitsFor(model(ModelePartie.class, idPartie))

              .contains(subTasks -> {

                    ajouterPoint(subTasks, idPartie);

              });
    }

    private static void ajouterPoint(BackendTasks tasks, String idPartie) {

        tasks.task("ajouterPoint" + "/" +idPartie)

             .waitsFor(message(MsgAjouterPoint.class, idPartie))

             .thenExecutes(inputs -> {

                 MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class, idPartie));
                 ModelePartie    partie          = inputs.get(model(ModelePartie.class, idPartie));

                 msgAjouterPoint.copierDonneesDans(partie);
                 msgAjouterPoint.ajouterPointA(partie);

             });
    }

}