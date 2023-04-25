package air_hockey.frontal.vues;



import java.net.URL;
import java.util.ResourceBundle;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import air_hockey.commun.valeurs.ActionJoueur;
import air_hockey.frontal.controles.CanvasPartie;
import air_hockey.frontal.evenements.EvtActionJoueur;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class VuePartie extends ViewFx {

	@FXML
	private Label labelNomPremierJoueur;

	@FXML
	private Label labelNomDeuxiemeJoueur;

	@FXML
	private Label labelScorePremierJoueur;

	@FXML
	private Label labelScoreDeuxiemeJoueur;

	@FXML
	private Button boutonQuitterPartie;

	@FXML
	private VBox vboxPartie;
	// ajouter
	@FXML
	private CanvasPartie canvasPartie;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		installerEvtAfficherMenuPrincipal();
		Ntro.assertNotNull(canvasPartie);
		Ntro.assertNotNull("vboxPartie", vboxPartie);
		installerEvtActionJoueur();

		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);

		Ntro.assertNotNull("labelScorePremierJoueur", labelScorePremierJoueur);
		Ntro.assertNotNull("labelScoreDeuxiemeJoueur", labelScoreDeuxiemeJoueur);

	}

	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomPremierJoueur.setText(nomPremierJoueur);
	}

	public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		labelNomDeuxiemeJoueur.setText(nomDeuxiemeJoueur);
	}

	public void afficherScorePremierJoueur(String scorePremierJoueur) {
		labelScorePremierJoueur.setText(scorePremierJoueur);
	}

	public void afficherScoreDeuxiemeJoueur(String scoreDeuxiemeJoueur) {
		labelScoreDeuxiemeJoueur.setText(scoreDeuxiemeJoueur);
	}

	private void installerEvtAfficherMenuPrincipal() {

		EvtAfficherMenuPrincipal evtNtro = NtroApp.newEvent(EvtAfficherMenuPrincipal.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}

	public void viderCanvas() {
		canvasPartie.clearCanvas();

	}

	public void afficherImagesParSeconde(String fps) {
		canvasPartie.afficherFps(fps);
	}

	public void afficherAir_Hockey2d(MondeAir_Hockey2d mondeAir_Hockey2d) {
		mondeAir_Hockey2d.drawOn(canvasPartie);
	}

	private void installerEvtActionJoueur() {

		EvtActionJoueur evtNtro = NtroApp.newEvent(EvtActionJoueur.class);

		vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

			if (evtFx.getCode().equals(KeyCode.W)) {

				evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.HAUT));
				evtNtro.trigger();

			} else if (evtFx.getCode().equals(KeyCode.S)) {

				evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.BAS));
				evtNtro.trigger();

			} else if (evtFx.getCode().equals(KeyCode.UP)) {

				evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.HAUT));
				evtNtro.trigger();

			} else if (evtFx.getCode().equals(KeyCode.DOWN)) {

				evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.BAS));
				evtNtro.trigger();
			}
		});

		vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

			if (evtFx.getCode().equals(KeyCode.W) || evtFx.getCode().equals(KeyCode.S)) {

				evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.ARRET));
				evtNtro.trigger();

			} else if (evtFx.getCode().equals(KeyCode.UP) || evtFx.getCode().equals(KeyCode.DOWN)) {

				evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.ARRET));
				evtNtro.trigger();
			}
		});
	}
}