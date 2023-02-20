package air_hockey.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import air_hockey.frontal.evenements.EvtAfficherHistorique;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class VueRacine extends ViewFx {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void afficherSousVue(ViewFx sousVue) {
		Pane racineSousVue = sousVue.rootNode();

		rootNode().getChildren().clear();
		rootNode().getChildren().add(racineSousVue);
	}

}
