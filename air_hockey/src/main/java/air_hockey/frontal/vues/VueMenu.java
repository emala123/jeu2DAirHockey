package air_hockey.frontal.vues;

import java.util.ResourceBundle;

import air_hockey.frontal.evenements.EvtAfficherHistorique;
import air_hockey.frontal.evenements.EvtAfficherPartie;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueMenu extends ViewFx{

	
	@FXML
	private Button boutonHistorique;

	@FXML
	private Button boutonPartie;

	
	@Override
	 public void initialiser() {
		// TODO Auto-generated method stub
	

				Ntro.assertNotNull("boutonHistorique", boutonHistorique);
				Ntro.assertNotNull("boutonPartie", boutonPartie);
			
				installerEvtAfficherHistorique();
				installerEvtAfficherPartie();
				

	}
	

	

	private void installerEvtAfficherPartie() {
		// TODO Auto-generated method stub
EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
boutonPartie.setOnAction(evtFx -> {

			System.out.println("[VueMenu] clic:" + evtFx.getEventType());
			evtNtro.trigger();

		});
	}




	private void installerEvtAfficherHistorique() {
		// TODO Auto-generated method stub
		EvtAfficherHistorique evtNtro = NtroApp.newEvent(EvtAfficherHistorique.class);
		
		boutonHistorique.setOnAction(evtFx -> {

			System.out.println("[VueMenu] clic:" + evtFx.getEventType());
			evtNtro.trigger();

		});
	}

}
