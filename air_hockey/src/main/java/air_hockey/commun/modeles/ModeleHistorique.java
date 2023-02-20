package air_hockey.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import air_hockey.commun.modeles.valeurs.Historique;
import air_hockey.commun.modeles.valeurs.Usager;
import air_hockey.frontal.vues.VueHistorique;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleHistorique implements Model, Watch, WriteObjectGraph{
	
	private List<Historique> lesParties = new ArrayList<>();

	
	public ModeleHistorique() {
		
		
		
	}





	public void afficherSur(VueHistorique vueHistorique) {
		vueHistorique.afficherHistoriqueEnTexte(this.toString());
	}





	public List<Historique> getLesParties() {
		return lesParties;
	}





	public void setLesParties(List<Historique> lesParties) {
		this.lesParties = lesParties;
	}






	
	@Override
	public String toString() {

	        StringBuilder builder = new StringBuilder();
	        int numeroPartie = 1;

	        for(Historique historique : lesParties) {

	            builder.append(numeroPartie);
	            builder.append(". ");
	            builder.append(historique.toString());
	            builder.append("\n");

	            numeroPartie++;
	        }

	        return builder.toString();
	    }

	
}
