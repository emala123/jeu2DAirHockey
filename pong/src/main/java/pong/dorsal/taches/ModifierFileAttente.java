package pong.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.messages.MsgRetirerRendezVous;
import pong.commun.modeles.ModeleFileAttente;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class ModifierFileAttente {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierFileAttente")

		     .waitsFor(model(ModeleFileAttente.class))

		     .contains(subTasks -> {
		    	  
				   ajouterRendezVous(subTasks);
				   
				   // ajouter
	                 retirerRendezVous(subTasks);

		      });
	}

	// ajouter
    private static void retirerRendezVous(BackendTasks subTasks) {
        subTasks.task("retirerRendezVous")

             .waitsFor(message(MsgRetirerRendezVous.class))
             
             .thenExecutes(inputs -> {

                 MsgRetirerRendezVous msgRetirerRendezVous = inputs.get(message(MsgRetirerRendezVous.class));
                 ModeleFileAttente    fileAttente          = inputs.get(model(ModeleFileAttente.class));

                 msgRetirerRendezVous.retirerDe(fileAttente);
             });

    }
	
	private static void ajouterRendezVous(BackendTasks tasks) {
		tasks.task("ajouterRendezVous")


		     .waitsFor(message(MsgAjouterRendezVous.class))
		     
		     .thenExecutes(inputs -> {

		    	 MsgAjouterRendezVous msgAjouterRendezVous = inputs.get(message(MsgAjouterRendezVous.class));
		    	 ModeleFileAttente    fileAttente          = inputs.get(model(ModeleFileAttente.class));

		    	 msgAjouterRendezVous.ajouterA(fileAttente);
		     });
	}

}
