package pong.frontal.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.evenements.EvtAfficherPartie;

public class FragmentRendezVous extends ViewFragmentFx {

    @FXML
    private Button boutonJoindrePartie;

    @FXML
    private Label labelNomPremierJoueur;

    @Override
    public void initialiser() {

        Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
        Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);

        installerEvtAfficherPartie();
    }

    private void installerEvtAfficherPartie() {

        EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);

        boutonJoindrePartie.setOnAction(evtFx -> {

            evtNtro.trigger();
        });
    }

    public void afficherNomPremierJoueur(String nomPremierJoueur) {
        labelNomPremierJoueur.setText(nomPremierJoueur);
    }
}
