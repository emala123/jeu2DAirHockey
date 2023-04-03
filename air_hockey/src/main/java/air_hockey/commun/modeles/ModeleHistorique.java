package air_hockey.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import air_hockey.commun.valeurs.Historique;
import air_hockey.commun.valeurs.Usager;
import air_hockey.frontal.vues.VueHistorique;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleHistorique implements Model, WriteObjectGraph {

	private long prochainIdPartie = 1;

	private List<Historique> lesParties = new ArrayList<>();

	public ModeleHistorique() {

	}

	public void afficherSur(VueHistorique vueHistorique) {
		vueHistorique.viderListePartie();

		// ajouter
		for (Historique partie : lesParties) {

			vueHistorique.ajouterPartie(partie);
		}
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

	public long getProchainIdPartie() {
		return prochainIdPartie;
	}

	public void setProchainIdPartie(long prochainIdPartie) {
		this.prochainIdPartie = prochainIdPartie;
	}

	public void ajouterPartie(Usager premierJoueur, Usager deuxiemeJoueur) {
		String idPartie = genererIdPartie();

		Historique historique = new Historique(idPartie, premierJoueur, deuxiemeJoueur);

		lesParties.add(historique);
	}

	public void retirerPartie(String idPartie) {
		int indicePartie = -1;

		for (int i = 0; i < lesParties.size(); i++) {
			if (lesParties.get(i).getIdPartie().equals(idPartie)) {
				indicePartie = i;
				break;
			}
		}

		if (indicePartie >= 0) {
			lesParties.remove(indicePartie);
		}
	}

	private String genererIdPartie() {
		String idHistorique = String.valueOf(prochainIdPartie);
		prochainIdPartie++;

		return idHistorique;

	}

}
