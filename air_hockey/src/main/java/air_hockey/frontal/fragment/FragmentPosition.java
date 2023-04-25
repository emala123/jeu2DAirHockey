package air_hockey.frontal.fragment;

import air_hockey.commun.messages.MsgRetirerJoueur;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentPosition extends ViewFragmentFx{

	@FXML
	private Label labelDescriptionJoueur;
	
	@FXML
	private Button boutonRetirerPositionJoueur;
	
	private String idPosition;
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("labelDescriptionJoueur", labelDescriptionJoueur);
		Ntro.assertNotNull(boutonRetirerPositionJoueur);
	}
	
	public void afficherDescriptionJoueur(String descriptionJoueur) {
		labelDescriptionJoueur.setText(descriptionJoueur);
	}
	
	public void memoriserIdPosition(String idPosition) {
		this.idPosition = idPosition;
		installerMsgRetirerJoueur(idPosition);
	}
	
	protected void installerMsgRetirerJoueur(String idPosition) {
		MsgRetirerJoueur msgRetirerJoueur = NtroApp.newMessage(MsgRetirerJoueur.class);
		msgRetirerJoueur.setIdPosition(idPosition);
		
		boutonRetirerPositionJoueur.setOnAction(evtFx -> {
			msgRetirerJoueur.send();
		});
	}

}
