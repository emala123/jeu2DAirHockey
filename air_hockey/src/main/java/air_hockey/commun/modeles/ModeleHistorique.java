package air_hockey.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import air_hockey.commun.valeurs.Historique;
import air_hockey.commun.valeurs.Usager;
import air_hockey.frontal.vues.VueHistorique;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleHistorique implements Model, WatchJson, WriteObjectGraph {

	private long prochainIdHistorique = 1;
	
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

		for (Historique historique : lesParties) {

			builder.append(numeroPartie);
			builder.append(". ");
			builder.append(historique.toString());
			builder.append("\n");

			numeroPartie++;
		}

		return builder.toString();
	}

	public long getProchainIdHistorique() {
		return prochainIdHistorique;
	}

	public void setProchainIdHistorique(long prochainIdHistorique) {
		this.prochainIdHistorique = prochainIdHistorique;
	}
	
	public void ajouterPartie(Usager premierJoueur, Usager deuxiemeJoueur) {
		String idHistorique = genererIdHistorique();
		
		Historique historique = new Historique(idHistorique, premierJoueur, deuxiemeJoueur);
		
		lesParties.add(historique);
	}

	private String genererIdHistorique() {
		String idHistorique = String.valueOf(prochainIdHistorique);
		prochainIdHistorique++;
		
		return idHistorique;
		
	}
	
}

