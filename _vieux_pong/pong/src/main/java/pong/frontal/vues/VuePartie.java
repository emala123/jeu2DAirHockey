package pong.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pong.evenements.EvtAfficherFileAttente;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitterPartie;
	
    @Override
    public void initialiser() {
    	Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
    	installerEvtAfficherFileAttente();
    }


	private void installerEvtAfficherFileAttente() {

		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}
    
}