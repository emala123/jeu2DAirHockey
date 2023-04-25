package air_hockey.commun.messages;

import air_hockey.commun.modeles.ModeleLeaderboard;
import air_hockey.commun.valeurs.Joueur;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterJoueur extends MessageNtro{

	private Joueur premierJoueur;
	
	public MsgAjouterJoueur() {
		
	}
	
	public void ajouterA(ModeleLeaderboard leaderboard) {
		
		leaderboard.ajouterJoueur(premierJoueur);
	}

	public Joueur getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Joueur premierJoueur) {
		this.premierJoueur = premierJoueur;
	}
}
