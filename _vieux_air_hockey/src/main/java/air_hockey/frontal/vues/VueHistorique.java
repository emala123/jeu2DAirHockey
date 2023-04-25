package air_hockey.frontal.vues;

import java.util.List;
import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.valeurs.Historique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import air_hockey.frontal.fragments.FragmentPartie;
import air_hockey.maquettes.MaquetteUsagers;
import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VueHistorique extends ViewFx {

	@FXML
	private Button boutonRetourMenu;

	@FXML
	private Button boutonAdd;

	@FXML
	private VBox conteneurHistorique;

	private ViewLoader<FragmentPartie> viewLoaderPartie;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonRetourMenu", boutonRetourMenu);
		Ntro.assertNotNull("boutonAdd", boutonAdd);
		Ntro.assertNotNull("conteneurHistorique", conteneurHistorique);
		installerMsgAjouterPartie();
		installerEvtAfficherMenuPrincipal();
	}

	private void installerEvtAfficherMenuPrincipal() {
		// TODO Auto-generated method stub

		EvtAfficherMenuPrincipal evtNtro = NtroApp.newEvent(EvtAfficherMenuPrincipal.class);

		boutonRetourMenu.setOnAction(evtFx -> {

			System.out.println("[VueHistorique] clic:" + evtFx.getEventType());
			evtNtro.trigger();

		});

	}

	// ajouter
	public void ajouterPartie(Historique partie) {
		FragmentPartie fragment = partie.creerFragment(viewLoaderPartie);
		partie.afficherSur(fragment);

		conteneurHistorique.getChildren().add(fragment.rootNode());
	}

	// ajouter
	public void viderListePartie() {
		conteneurHistorique.getChildren().clear();
	}

	private void installerMsgAjouterPartie() {
		// TODO Auto-generated method stub
		MsgAjouterPartie msgAjouterPartie = NtroApp.newMessage(MsgAjouterPartie.class);

		boutonAdd.setOnAction(evtFx -> {
			msgAjouterPartie.setPremierJoueur(MaquetteUsagers.usagerCourant());
			MaquetteUsagers.prochainUsager();
			msgAjouterPartie.setDeuxiemeJoueur(MaquetteUsagers.usagerCourant());
			msgAjouterPartie.send();

			MaquetteUsagers.prochainUsager();
		});
	}

	public void afficher(ModeleHistorique modele) {

		List<Historique> historique = modele.getLesParties();

	}

	public ViewLoader<FragmentPartie> getViewLoaderPartie() {
		return viewLoaderPartie;
	}

	public void setViewLoaderPartie(ViewLoader<FragmentPartie> viewLoaderPartie) {
		this.viewLoaderPartie = viewLoaderPartie;
	}

}
