package pong.frontal.vues;

import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.fx.controls.ResizableAvatar;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.valeurs.RendezVous;
import pong.evenements.EvtAfficherPartie;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;
import pong.maquettes.MaquetteUsagers;

public class VueFileAttente extends ViewFx {

	@FXML
	private VBox conteneurRendezVous;

	@FXML
	private Button boutonSInscrire;
	
	 @FXML
	private ComboBox<RendezVous> comboRendezVous;
	
	 @FXML
	 private ResizableAvatar logo;  // ajouter

	 private ViewLoader<FragmentRendezVous> viewLoaderRendezVous;
	 
	 private ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours;
	 
	 
	 private class ListCellRendezVous extends ListCell<RendezVous> {

	        @Override
	        protected void updateItem(RendezVous rendezVous, boolean empty) {
	            super.updateItem(rendezVous, empty);
	            
	            if(rendezVous == null || empty) {

	                setGraphic(null);

	            }else {
	                
	                FragmentRendezVous fragment = rendezVous.creerFragment(viewLoaderRendezVous, viewLoaderPartieEnCours);
	                rendezVous.afficherSur(fragment);
	                setGraphic(fragment.rootNode());

	            }
	        }
	    }
	 
	 
	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonSInscrire", boutonSInscrire);
		Ntro.assertNotNull("conteneurRendezVous", conteneurRendezVous);
		Ntro.assertNotNull(logo);
        logo.setImage(new Image("/avatar.png"));
        initialiserComboRendezVous();

	}
	
	private void initialiserComboRendezVous() {
        comboRendezVous.setButtonCell(new ListCellRendezVous());
        comboRendezVous.setCellFactory(new Callback<ListView<RendezVous>, ListCell<RendezVous>>() {
            @Override
            public ListCell<RendezVous> call(ListView<RendezVous> param) {
                return new ListCellRendezVous();
            }
        });
    }
	
	 public void ajouterRendezVous(RendezVous rendezVous) {
         FragmentRendezVous fragment = rendezVous.creerFragment(viewLoaderRendezVous, viewLoaderPartieEnCours);
         rendezVous.afficherSur(fragment);

         conteneurRendezVous.getChildren().add(fragment.rootNode());
         comboRendezVous.getItems().add(rendezVous);
         comboRendezVous.setValue(comboRendezVous.getItems().get(comboRendezVous.getItems().size() - 1));
     }
	
	 public void viderListeRendezVous() {
         conteneurRendezVous.getChildren().clear();
         comboRendezVous.getItems().clear();
     }
	 
	public void afficher(ModeleFileAttente modele) {

		List<RendezVous> rendezVous = modele.getLesRendezVous();

	}

	public ViewLoader<FragmentRendezVous> getViewLoaderRendezVous() {
		return viewLoaderRendezVous;
	}

	public void setViewLoaderRendezVous(ViewLoader<FragmentRendezVous> viewLoaderRendezVous) {
		this.viewLoaderRendezVous = viewLoaderRendezVous;
	}

	public ViewLoader<FragmentPartieEnCours> getViewLoaderPartieEnCours() {
		return viewLoaderPartieEnCours;
	}

	public void setViewLoaderPartieEnCours(ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {
		this.viewLoaderPartieEnCours = viewLoaderPartieEnCours;
	}

}
