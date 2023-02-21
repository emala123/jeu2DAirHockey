package air_hockey.commun.messages;

import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.valeurs.Usager;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterPartie extends MessageNtro{

	private Usager premierJoueur;
	private Usager deuxiemeJoueur;
	
	 public MsgAjouterPartie() {
	    }

	public Usager getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Usager premierJoueur) {
		this.premierJoueur = premierJoueur;
	}
	
	public void ajouterA(ModeleHistorique historique) {
		historique.ajouterPartie(premierJoueur, deuxiemeJoueur);
	}

	public Usager getDeuxiemeJoueur() {
		return deuxiemeJoueur;
	}

	public void setDeuxiemeJoueur(Usager deuxiemeJoueur) {
		this.deuxiemeJoueur = deuxiemeJoueur;
	}
	
}
