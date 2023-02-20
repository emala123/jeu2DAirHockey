package air_hockey.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.valeurs.Historique;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VueHistorique extends ViewFx {

	  @FXML
	    private Label labelParties;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Ntro.assertNotNull("labelParties", labelParties);
	}



	    public void afficher(ModeleHistorique modele){

	        List<Historique> historique = modele.getHistorique();

	  
	}

	    public void afficherHistoriqueEnTexte(String msg) {
	    	labelParties.setText(msg);
	    }
	    
	
}
