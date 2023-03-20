package pong.frontal.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.commun.messages.MsgRetirerRendezVous;
import pong.evenements.EvtAfficherPartie;

public class FragmentRendezVous extends ViewFragmentFx {

    @FXML
    private Button boutonJoindrePartie;

    @FXML
    private Label labelNomPremierJoueur;

    // ajouter
    @FXML
    private Button boutonRetirerRendezVous;
    
    // ajouter
    private String idRendezVous;
    
 
    @Override
    public void initialiser() {

        Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
        Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
        Ntro.assertNotNull(boutonRetirerRendezVous);

        installerEvtAfficherPartie();
    }

 // ajouter
    public void memoriserIdRendezVous(String idRendezVous) {
        this.idRendezVous = idRendezVous;
        installerMsgRetirerRendezVous(idRendezVous);
    }
    
    
 // ajouter
    protected void installerMsgRetirerRendezVous(String idRendezVous) {

        MsgRetirerRendezVous msgRetirerRendezVous = NtroApp.newMessage(MsgRetirerRendezVous.class);
        msgRetirerRendezVous.setIdRendezVous(idRendezVous);
        
        boutonRetirerRendezVous.setOnAction(evtFx -> {
            msgRetirerRendezVous.send();
        });
        
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
