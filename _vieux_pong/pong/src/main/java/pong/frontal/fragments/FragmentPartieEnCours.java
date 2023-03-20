package pong.frontal.fragments;

import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FragmentPartieEnCours extends FragmentRendezVous {

    @FXML
    private Label labelNomDeuxiemeJoueur;

    @Override
    public void initialiser() {
        super.initialiser();

        Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);
    }

    public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
        labelNomDeuxiemeJoueur.setText(nomDeuxiemeJoueur);
    }
}
