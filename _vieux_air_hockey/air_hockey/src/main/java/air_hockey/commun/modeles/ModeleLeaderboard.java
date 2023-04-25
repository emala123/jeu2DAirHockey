package air_hockey.commun.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import air_hockey.commun.valeurs.Joueur;
import air_hockey.commun.valeurs.position;
import air_hockey.frontal.vues.VueLeaderboard;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleLeaderboard implements Model, WriteObjectGraph{

	private long prochainIdPosition = 1;
	private List<position> lesPositions = new ArrayList<>();
	
	public List<position> getLesPositions() {
		return lesPositions;
	}

	public void setLesPositions(List<position> lesPositions) {
		this.lesPositions = lesPositions;
	}

	public long getProchainIdPosition() {
		return prochainIdPosition;
	}

	public void setProchainIdPosition(long prochainIdPosition) {
		this.prochainIdPosition = prochainIdPosition;
	}
	
	public ModeleLeaderboard() {
		super();
	}
	
	public void afficherSur(VueLeaderboard vueLeaderboard) {
		
		vueLeaderboard.viderListeLeaderboard();
		
		for(position position : lesPositions) {
			vueLeaderboard.ajouterPosition(position);
		}
		
		//Dire a l'utilisateur de rajouter un joueur si la liste est vide
		Locale langueLocale = Locale.getDefault();
		String langueString = langueLocale.getLanguage();
		
		if(lesPositions.size() == 0) {
			
			if(langueString == "fr") {
				System.out.println("Le classement est vide, rajouter un joueur!");
			}else if(langueString == "en") {
				System.out.println("The Leaderboard is empty, add a player to fill it up!");
			}else if(langueString == "es"){
				System.out.println("La tabla de clasificación está vacía, agrega un jugador!");
			}
		}
	}
	
	public void ajouterJoueur(Joueur premierJoueur) {
		
		String idPos = genererIdPosition();
		position joueur = new position(idPos, premierJoueur);
		
		Locale langueLocale = Locale.getDefault();
		String langueString = langueLocale.getLanguage();
		
		boolean siJoueurAjouter = false;
		
		//Ajouter un joueur a la liste si elle est vide, si non placer le joueur qui a le plus de point en premier (comme ça avec tout les index de la liste)
		if(lesPositions.size() == 0) {
			lesPositions.add(joueur);
			if(langueString == "fr") {
				System.out.println("Le classement n'est pu vide!");
			}else if(langueString == "en") {
				System.out.println("The Leaderboard is not anymore empty!");
			}else if(langueString == "es"){
				System.out.println("La tabla de clasificación ya no está vacía!");
			}
		}else {
		
		for(int i = 0; i < lesPositions.size(); i++) {
			
			//si le nouveau joueur enregistrer a plus de point qu'un ancien joueur enregistrer on le met devant
			if(joueur.getJoueur().getPoint() > lesPositions.get(i).getJoueur().getPoint()) {
				lesPositions.add(i, joueur);
				siJoueurAjouter = true;
				break;
			}
		}
		
		// si non l'Ajouter a la fin de la liste
		if(siJoueurAjouter == false) {
			lesPositions.add(joueur);
		}
	}
		
}
	
	public String genererIdPosition() {
		String idPos = String.valueOf(prochainIdPosition);
		prochainIdPosition++;
		
		return idPos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int numeroPosition = 1;
		
		for(position descriptionPosition: lesPositions) {
			
			builder.append(numeroPosition);
			builder.append(". ");
			builder.append(descriptionPosition.toString());
			builder.append("\n");
			
			numeroPosition++;
		}
		
		return builder.toString();
	}
	
	public void retirerPosition(String idPosition) {
		int indicePosition = -1;
		
		for(int i = 0; i < lesPositions.size(); i++) {
			if(lesPositions.get(i).getIdPosition().equals(idPosition)) {
				indicePosition = i;
				break;
			}
		}
		
		if(indicePosition >= 0) {
			lesPositions.remove(indicePosition);
		}
	}
	
}
