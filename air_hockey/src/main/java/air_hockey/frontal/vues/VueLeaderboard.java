package air_hockey.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import air_hockey.commun.messages.MsgAjouterJoueur;
import air_hockey.commun.valeurs.position;
import air_hockey.frontal.evenements.EvtAfficherAccueil;
import air_hockey.frontal.fragment.FragmentPosition;
import air_hockey.maquettes.MaquetteJoueurs;
import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.fx.controls.ResizableImage;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class VueLeaderboard extends ViewFx{
	
	@FXML
	private Button boutonRetourAcceuil;
	
	@FXML
	private Button boutonAjouterJoueur;
	
	@FXML
	private VBox conteneurLeaderboard;
	
	@FXML
	private ResizableImage logo;
	
	private ViewLoader<FragmentPosition> viewLoaderPosition;
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonRetourAcceuil", boutonRetourAcceuil);
		Ntro.assertNotNull("boutonAjouterJoueur", boutonAjouterJoueur);
		Ntro.assertNotNull("conteneurLeaderboard", conteneurLeaderboard);
		Ntro.assertNotNull(logo);
		
		logo.setImage(new Image("/Leaderboard_image.png"));
		
		installerEvtAfficherAcceuil();
		installerMsgAjouterJoueur();
	}
	
	public void installerEvtAfficherAcceuil() {
		
		boutonRetourAcceuil.setOnAction(evtFx ->{
			System.out.println("[VueLeaderboard] clic: " + evtFx.getEventType());
		});
		
		EvtAfficherAccueil evtNtro = NtroApp.newEvent(EvtAfficherAccueil.class);
		
		boutonRetourAcceuil.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
		
	}
	
	public void installerMsgAjouterJoueur() {
		MsgAjouterJoueur msgAjouterJoueur = NtroApp.newMessage(MsgAjouterJoueur.class);
		
		boutonAjouterJoueur.setOnAction(evtFx -> {
		
		msgAjouterJoueur.setPremierJoueur(MaquetteJoueurs.joueurCourant());
		msgAjouterJoueur.send();
		
		MaquetteJoueurs.prochainJoueur();
		});
	}

	public ViewLoader<FragmentPosition> getViewLoaderPosition() {
		return viewLoaderPosition;
	}

	public void setViewLoaderPosition(ViewLoader<FragmentPosition> viewLoaderPosition) {
		this.viewLoaderPosition = viewLoaderPosition;
	}
	
	public void ajouterPosition(position positionPosition) {
		FragmentPosition fragment = positionPosition.creerFragment(viewLoaderPosition);
		positionPosition.afficherSur(fragment);
		
		conteneurLeaderboard.getChildren().add(fragment.rootNode());
	}
	
	public void viderListeLeaderboard() {
		conteneurLeaderboard.getChildren().clear();
	}

}
