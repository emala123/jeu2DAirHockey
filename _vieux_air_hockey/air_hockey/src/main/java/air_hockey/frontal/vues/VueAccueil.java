package air_hockey.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import air_hockey.frontal.evenements.EvtAfficherLeaderboard;
import air_hockey.frontal.evenements.EvtAfficherPartie;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueAccueil extends ViewFx{

	@FXML
	private Button boutonLeaderboard;
	
	@FXML
	private Button boutonJoindrePartie;
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonLeaderboard", boutonLeaderboard);
		Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
		
		installerEvtAfficherLeaderboard();
		
		installerEvtAfficherPartie();
	}
	
	public void installerEvtAfficherLeaderboard() {
		
		boutonLeaderboard.setOnAction(evtFx -> {
			System.out.println("[VueAccueil] clic: " + evtFx.getEventType());
		});

			EvtAfficherLeaderboard evtNtro = NtroApp.newEvent(EvtAfficherLeaderboard.class);

			boutonLeaderboard.setOnAction(evtFx -> {

				evtNtro.trigger();
			});
	}
	
	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
		boutonJoindrePartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
			
		});
	}

}
