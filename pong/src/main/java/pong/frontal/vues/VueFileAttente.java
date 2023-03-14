package pong.frontal.vues;

import java.util.List;
import java.util.ResourceBundle;

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
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.RendezVous;
import pong.evenements.EvtAfficherPartie;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;
import pong.maquettes.MaquetteUsagers;

public class VueFileAttente extends ViewFx {

	@FXML
	private VBox conteneurRendezVous;

	@FXML
	private Button boutonSInscrire;
	
	 @FXML
	 private ResizableAvatar logo;  // ajouter

	 private ViewLoader<FragmentRendezVous> viewLoaderRendezVous;
	 
	 private ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours;
	 
	 
	 
	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonSInscrire", boutonSInscrire);
		Ntro.assertNotNull("conteneurRendezVous", conteneurRendezVous);
		Ntro.assertNotNull(logo);
        logo.setImage(new Image("/avatar.png"));

	}
	
	 public void ajouterRendezVous(RendezVous rendezVous) {
         FragmentRendezVous fragment = rendezVous.creerFragment(viewLoaderRendezVous, viewLoaderPartieEnCours);
         rendezVous.afficherSur(fragment);

         conteneurRendezVous.getChildren().add(fragment.rootNode());
     }
	
	 public void viderListeRendezVous() {
         conteneurRendezVous.getChildren().clear();
     }
	 
	public void afficher(ModeleFileAttente modele) {

		List<RendezVous> rendezVous = modele.getLesRendezVous();

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
