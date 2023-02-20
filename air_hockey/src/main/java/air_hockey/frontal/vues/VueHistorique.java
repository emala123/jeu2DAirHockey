package air_hockey.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.valeurs.Historique;
import air_hockey.frontal.evenements.EvtAfficherMenuPrincipal;
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


	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("labelParties", labelParties);
		Ntro.assertNotNull("boutonRetourMenu", boutonRetourMenu);
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



		public void afficher(ModeleHistorique modele){

	        List<Historique> historique = modele.getLesParties();

	  
	}

	    public void afficherHistoriqueEnTexte(String msg) {
	    	labelParties.setText(msg);
	    }
	    
	
}
