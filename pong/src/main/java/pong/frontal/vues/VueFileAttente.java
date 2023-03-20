package pong.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.fx.controls.ResizableAvatar;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.valeurs.RendezVous;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;
import pong.maquettes.MaquetteUsagers;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonSInscrire;

	@FXML
	private VBox conteneurRendezVous;

	@FXML
	private ResizableAvatar logo; // ajouter

	private ViewLoader<FragmentRendezVous> viewLoaderRendezVous;
	private ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours;

	
	
	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonSInscrire", boutonSInscrire);
		Ntro.assertNotNull("conteneurRendezVous", conteneurRendezVous);
		installerMsgAjouterRendezVous();
		Ntro.assertNotNull(logo);
		logo.setImage(new Image("/avatar.png"));
	}

	// ajouter
	public void ajouterRendezVous(RendezVous rendezVous) {
		FragmentRendezVous fragment = rendezVous.creerFragment(viewLoaderRendezVous, viewLoaderPartieEnCours);
		rendezVous.afficherSur(fragment);

		conteneurRendezVous.getChildren().add(fragment.rootNode());
	}

	// ajouter
	public void viderListeRendezVous() {
		conteneurRendezVous.getChildren().clear();
	}

	private void installerMsgAjouterRendezVous() {

		MsgAjouterRendezVous msgAjouterRendezVous = NtroApp.newMessage(MsgAjouterRendezVous.class);

		boutonSInscrire.setOnAction(evtFx -> {

			msgAjouterRendezVous.setPremierJoueur(MaquetteUsagers.usagerCourant());
			msgAjouterRendezVous.send();

			MaquetteUsagers.prochainUsager();
		});
	}

	public ViewLoader<FragmentRendezVous> getViewLoaderRendezVous() {
		return viewLoaderRendezVous;
	}

	public void setViewLoaderRendezVous(ViewLoader<FragmentRendezVous> viewLoaderRendezVous) {
		this.viewLoaderRendezVous = viewLoaderRendezVous;
	}

	public ViewLoader<FragmentPartieEnCours> getViewLoaderPartieEnCours() {
		return viewLoaderPartieEnCours;
	}

	public void setViewLoaderPartieEnCours(ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {
		this.viewLoaderPartieEnCours = viewLoaderPartieEnCours;
	}

}
