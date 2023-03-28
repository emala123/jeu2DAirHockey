package pong.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import pong.commun.enums.Action;
import pong.commun.enums.Cadran;
import pong.commun.monde2d.MondePong2d;
import pong.commun.valeurs.ActionJoueur;
import pong.evenements.EvtActionJoueur;
import pong.frontal.controles.CanvasPartie;
import pong.frontal.evenements.EvtAfficherFileAttente;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitterPartie;

	// ajouter
	@FXML
	private CanvasPartie canvasPartie;

	@FXML
	private Label labelNomPremierJoueur;

	@FXML
	private Label labelNomDeuxiemeJoueur;

	@FXML
	private Label labelScorePremierJoueur;

	@FXML
	private Label labelScoreDeuxiemeJoueur;
	
	  @FXML
	    private VBox vboxPartie;

	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		Ntro.assertNotNull(canvasPartie);
		installerEvtAfficherFileAttente();
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);

		Ntro.assertNotNull("labelScorePremierJoueur", labelScorePremierJoueur);
		Ntro.assertNotNull("labelScoreDeuxiemeJoueur", labelScoreDeuxiemeJoueur);
		Ntro.assertNotNull("vboxPartie", vboxPartie);
		 installerEvtActionJoueur();
	}

	 private void installerEvtActionJoueur() {

	        EvtActionJoueur evtNtro = NtroApp.newEvent(EvtActionJoueur.class);

	        vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

	            if(evtFx.getCode().equals(KeyCode.W)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.HAUT));
	                evtNtro.trigger();

	            }else if(evtFx.getCode().equals(KeyCode.S)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.BAS));
	                evtNtro.trigger();

	            }else if(evtFx.getCode().equals(KeyCode.UP)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.HAUT));
	                evtNtro.trigger();

	            }else if(evtFx.getCode().equals(KeyCode.DOWN)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.BAS));
	                evtNtro.trigger();
	            }
	        });

	        vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

	            if(evtFx.getCode().equals(KeyCode.W)
	                    || evtFx.getCode().equals(KeyCode.S)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.ARRET));
	                evtNtro.trigger();

	            }else if(evtFx.getCode().equals(KeyCode.UP)
	                    || evtFx.getCode().equals(KeyCode.DOWN)) {

	                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.ARRET));
	                evtNtro.trigger();
	            }
	        });
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

	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}

	public void afficherImagesParSeconde(String fps) {
		canvasPartie.afficherFps(fps);
	}

	public void afficherPong2d(MondePong2d mondePong2d) {
		mondePong2d.drawOn(canvasPartie);
	}

	private void installerEvtAfficherFileAttente() {

		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}

}
