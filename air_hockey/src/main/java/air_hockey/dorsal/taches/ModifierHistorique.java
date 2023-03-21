package air_hockey.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.messages.MsgRetirerPartie;
import air_hockey.commun.modeles.ModeleHistorique;
import ca.ntro.app.tasks.backend.BackendTasks;

public class ModifierHistorique {

    public static void creerTaches(BackendTasks tasks) {

        tasks.taskGroup("ModifierHistorique")

             .waitsFor(model(ModeleHistorique.class))

             .andContains(subTasks -> {

                  // Ajouter ici chaque tâche 
                  // qui modifie le modèle
            	 
            	 ajouterPartie(subTasks);
            	 retirerPartie(subTasks);
              });
    }

	private static void ajouterPartie(BackendTasks subTasks) {
		// TODO Auto-generated method stub
		subTasks.task("ajouterPartie")
		
			.waitsFor(message(MsgAjouterPartie.class))
			
			.thenExecutes(inputs -> {
				
				MsgAjouterPartie msgAjouterPartie = inputs.get(message(MsgAjouterPartie.class));
				ModeleHistorique historique = inputs.get(model(ModeleHistorique.class));
				
				msgAjouterPartie.ajouterA(historique);
				
			});
	}
	
	// ajouter
    private static void retirerPartie(BackendTasks subTasks) {
        subTasks.task("retirerPartie")

             .waitsFor(message(MsgRetirerPartie.class))
             
             .thenExecutes(inputs -> {

            	 MsgRetirerPartie msgRetirerPartie = inputs.get(message(MsgRetirerPartie.class));
                 ModeleHistorique    historique          = inputs.get(model(ModeleHistorique.class));

                 msgRetirerPartie.retirerDe(historique);
             });

    }
}