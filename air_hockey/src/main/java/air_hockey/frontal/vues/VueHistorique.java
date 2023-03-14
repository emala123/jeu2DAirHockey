package air_hockey.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.valeurs.Historique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
import air_hockey.maquettes.MaquetteUsagers;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VueHistorique extends ViewFx {

	  @FXML
	    private Label labelParties;
	
	 

	  @FXML
		private Button boutonRetourMenu;


	  @FXML
	  	private Button boutonAdd;
	  
	  
	@Override
	 public void initialiser() {
		Ntro.assertNotNull("labelParties", labelParties);
		Ntro.assertNotNull("boutonRetourMenu", boutonRetourMenu);
		Ntro.assertNotNull("boutonAdd", boutonAdd);
		installerEvtAfficherMenuPrincipal();
		installerMsgAjouterPartie();
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



		private void installerEvtAfficherMenuPrincipal() {
		// TODO Auto-generated method stub
	    	

					EvtAfficherMenuPrincipal evtNtro = NtroApp.newEvent(EvtAfficherMenuPrincipal.class);

					boutonRetourMenu.setOnAction(evtFx -> {
						
						System.out.println("[VueHistorique] clic:" + evtFx.getEventType());
						evtNtro.trigger();

					});
				
	}



		public void afficher(ModeleHistorique modele){

	        List<Historique> historique = modele.getLesParties();

	  
	}

	    public void afficherHistoriqueEnTexte(String msg) {
	    	labelParties.setText(msg);
	    }
	    
	
}
