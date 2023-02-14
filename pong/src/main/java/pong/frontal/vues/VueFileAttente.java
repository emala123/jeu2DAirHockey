package pong.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.RendezVous;
import pong.evenements.EvtAfficherPartie;

public class VueFileAttente extends ViewFx {

	@FXML
	private Label labelRendezVous;

	@FXML
	private Button boutonJoindrePartie;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("labelRendezVous", labelRendezVous);
		Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
		installerEvtAfficherPartie();
	}

	private void installerEvtAfficherPartie() {

		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);

		boutonJoindrePartie.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}

	public void afficher(ModeleFileAttente modele) {

		List<RendezVous> rendezVous = modele.getLesRendezVous();

	}

	public void afficherRendezVousEnTexte(String message) {
		labelRendezVous.setText(message);
	}

}
