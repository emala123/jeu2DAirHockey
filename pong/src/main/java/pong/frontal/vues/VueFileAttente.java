package pong.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VueFileAttente extends ViewFx {

	@FXML
    private Label labelRendezVous;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		 Ntro.assertNotNull("labelRendezVous", labelRendezVous);
		
	}

}
