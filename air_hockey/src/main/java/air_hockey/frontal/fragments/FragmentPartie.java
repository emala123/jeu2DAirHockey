package air_hockey.frontal.fragments;

import air_hockey.commun.messages.MsgRetirerPartie;
import air_hockey.frontal.evenements.EvtAfficherHistorique;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentPartie extends ViewFragmentFx {

	@FXML
	private Label labelNomPremierJoueur;

	@FXML
	private Label labelNomDeuxiemeJoueur;

	// ajouter
	@FXML
	private Button boutonRetirerPartie;

	// ajouter
	private String idPartie;

	// ajouter
	public void memoriserIdPartie(String idPartie) {
		this.idPartie = idPartie;
		installerMsgRetirerPartie(idPartie);
	}

	@Override
	public void initialiser() {
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		Ntro.assertNotNull("boutonRetirerPartie", boutonRetirerPartie);
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomDeuxiemeJoueur);

	}

	// ajouter
	protected void installerMsgRetirerPartie(String idPartie) {

		MsgRetirerPartie msgRetirerPartie = NtroApp.newMessage(MsgRetirerPartie.class);
		msgRetirerPartie.setIdPartie(idPartie);

		boutonRetirerPartie.setOnAction(evtFx -> {
			msgRetirerPartie.send();
		});

	}

	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomPremierJoueur.setText(nomPremierJoueur);

	}
	public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		labelNomDeuxiemeJoueur.setText(" VS "+nomDeuxiemeJoueur);

	}


}