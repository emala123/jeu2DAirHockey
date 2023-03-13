package pong.frontal.vues;

import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.RendezVous;
import pong.evenements.EvtAfficherPartie;
import pong.maquettes.MaquetteUsagers;

public class VueFileAttente extends ViewFx {

	@FXML
	private Label labelRendezVous;

	@FXML
	private Button boutonJoindrePartie;

	@FXML
    private Button boutonSInscrire;
	
	@Override
	 public void initialiser() {
		Ntro.assertNotNull("labelRendezVous", labelRendezVous);
		Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
		Ntro.assertNotNull("boutonSInscrire", boutonSInscrire);
		installerEvtAfficherPartie();
		installerMsgAjouterRendezVous();


	}
	


    private void installerMsgAjouterRendezVous() {

        MsgAjouterRendezVous msgAjouterRendezVous = NtroApp.newMessage(MsgAjouterRendezVous.class);

        boutonSInscrire.setOnAction(evtFx -> {

            // l'usager courant s'inscrit
            msgAjouterRendezVous.setPremierJoueur(MaquetteUsagers.usagerCourant());
            msgAjouterRendezVous.send();

            // à chaque clic, on passe à un nouvel usager
            MaquetteUsagers.prochainUsager();

        });
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
