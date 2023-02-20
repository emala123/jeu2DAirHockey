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
	
	private List<Historique> historique = new ArrayList<>();

	
	public ModeleHistorique() {
		
		
		
	}





	public void afficherSur(VueHistorique vueHistorique) {
		vueHistorique.afficherHistoriqueEnTexte(this.toString());
	}






	
	@Override
	public String toString() {

	        StringBuilder builder = new StringBuilder();
	        int numeroPartie = 1;

	        for(Historique historique : historique) {

	            builder.append(numeroPartie);
	            builder.append(". ");
	            builder.append(historique.toString());
	            builder.append("\n");

	            numeroPartie++;
	        }

	        return builder.toString();
	    }





	public List<Historique> getHistorique() {
		return historique;
	}





	public void setHistorique(List<Historique> historique) {
		this.historique = historique;
	}

	
}
