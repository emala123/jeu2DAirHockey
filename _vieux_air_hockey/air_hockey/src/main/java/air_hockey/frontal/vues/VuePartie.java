package air_hockey.frontal.vues;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.enums.Touche;
import air_hockey.commun.monde2d.MondeAirHockey2d;
import air_hockey.commun.valeurs.TouchesActivesParCadran;
import air_hockey.frontal.controles.CanvasPartie;
import air_hockey.frontal.evenements.EvtAfficherAccueil;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class VuePartie extends ViewFx{

	@FXML
	private Button boutonQuitterPartie;
	
	@FXML
	private CanvasPartie canvasPartie;
	
	@FXML 
	private Label labelPremierJoueur;
	
	@FXML
	private Label labelDeuxiemeJoueur;
	
	@FXML
	private Label labelScorePremierJoueur;
	
	@FXML
	private Label labelScoreDeuxiemeJoueur;
	
	@FXML
	private VBox vboxPartie;
	
	private TouchesActivesParCadran touchesActivesParCadran = new TouchesActivesParCadran();
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		
		Ntro.assertNotNull("labelPremierJoueur", labelPremierJoueur);
		Ntro.assertNotNull("labelDeuxiemeJoueur", labelDeuxiemeJoueur);
		
		Ntro.assertNotNull("labelScorePremierJoueur", labelScorePremierJoueur);
		Ntro.assertNotNull("labelScoreDeuxiemeJoueur", labelScoreDeuxiemeJoueur);
		
		Ntro.assertNotNull("vboxPartie", vboxPartie);
		
		Ntro.assertNotNull(canvasPartie);
		
		installerEvtAfficherAcceuil();
		installerCapteursTouches();
	}

	private void installerEvtAfficherAcceuil() {
		
		EvtAfficherAccueil evtNtro = NtroApp.newEvent(EvtAfficherAccueil.class);
		
		boutonQuitterPartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
			
		});
	}
	
	private void installerCapteursTouches() {

		installerCapteurToucheAppuyee();
		installerCapteurToucheRelachee();
		
	}

	private void installerCapteurToucheAppuyee() {

		vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

			reagirSiToucheAppuyeeGauche(evtFx);
			reagirSiToucheAppulyeeDroite(evtFx);

		});
	}

	private void reagirSiToucheAppuyeeGauche(KeyEvent evtFx) {
		if(evtFx.getCode().equals(KeyCode.W)) {

			touchesActivesParCadran.activer(Cadran.GAUCHE, Touche.HAUT);
			
		}else if(evtFx.getCode().equals(KeyCode.A)) {

			touchesActivesParCadran.activer(Cadran.GAUCHE, Touche.GAUCHE);
			
		}else if (evtFx.getCode().equals(KeyCode.S)) {

			touchesActivesParCadran.activer(Cadran.GAUCHE, Touche.BAS);
			
		}else if (evtFx.getCode().equals(KeyCode.D)) {

			touchesActivesParCadran.activer(Cadran.GAUCHE, Touche.DROITE);

		}
	}

	private void reagirSiToucheAppulyeeDroite(KeyEvent evtFx) {
		if (evtFx.getCode().equals(KeyCode.UP)) {

			touchesActivesParCadran.activer(Cadran.DROITE, Touche.HAUT);
			
		}else if (evtFx.getCode().equals(KeyCode.RIGHT)) {

			touchesActivesParCadran.activer(Cadran.DROITE, Touche.DROITE);
			
		}else if (evtFx.getCode().equals(KeyCode.DOWN)) {

			touchesActivesParCadran.activer(Cadran.DROITE, Touche.BAS);
			
		}else if (evtFx.getCode().equals(KeyCode.LEFT)) {

			touchesActivesParCadran.activer(Cadran.DROITE, Touche.GAUCHE);

		}
	}

	private void installerCapteurToucheRelachee() {
		vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {
			
			reagirSiToucheRelacheeGauche(evtFx);
			reagirSiToucheRelacheeDroite(evtFx);

		});
	}


	private void reagirSiToucheRelacheeGauche(KeyEvent evtFx) {
		if(evtFx.getCode().equals(KeyCode.W)) {

			touchesActivesParCadran.desactiver(Cadran.GAUCHE, Touche.HAUT);
			
		}else if(evtFx.getCode().equals(KeyCode.A)) {

			touchesActivesParCadran.desactiver(Cadran.GAUCHE, Touche.GAUCHE);
			
		}else if (evtFx.getCode().equals(KeyCode.S)) {

			touchesActivesParCadran.desactiver(Cadran.GAUCHE, Touche.BAS);
			
		}else if (evtFx.getCode().equals(KeyCode.D)) {

			touchesActivesParCadran.desactiver(Cadran.GAUCHE, Touche.DROITE);

		}
	}

	private void reagirSiToucheRelacheeDroite(KeyEvent evtFx) {
		if (evtFx.getCode().equals(KeyCode.UP)) {

			touchesActivesParCadran.desactiver(Cadran.DROITE, Touche.HAUT);
			
		}else if (evtFx.getCode().equals(KeyCode.RIGHT)) {

			touchesActivesParCadran.desactiver(Cadran.DROITE, Touche.DROITE);
			
		}else if (evtFx.getCode().equals(KeyCode.DOWN)) {

			touchesActivesParCadran.desactiver(Cadran.DROITE, Touche.BAS);
			
		}else if (evtFx.getCode().equals(KeyCode.LEFT)) {

			touchesActivesParCadran.desactiver(Cadran.DROITE, Touche.GAUCHE);

		}
	}

	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}

	public void afficherImagesParSecondes(String fps) {
		canvasPartie.afficherFps(fps);
	}

	public void afficherAirHockey2d(MondeAirHockey2d mondeAirHockey2d) {
		mondeAirHockey2d.drawOn(canvasPartie);
	}
	
	public void afficherPremierJoueur(String premierJoueur) {
		labelPremierJoueur.setText(premierJoueur);
	}
	
	public void afficherDeuxiemeJoueur(String deuxiemeJoueur) {
		labelDeuxiemeJoueur.setText(deuxiemeJoueur);
	}
	
	public void afficherScorePremierJoueur(String scorePremierJoueur) {
		labelScorePremierJoueur.setText(scorePremierJoueur);
	}
	
	public void afficherScoreDeuxiemeJoueur(String scoreDeuxiemeJoueur) {
		labelScoreDeuxiemeJoueur.setText(scoreDeuxiemeJoueur);
	}

}
