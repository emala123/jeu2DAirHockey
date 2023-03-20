package pong.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.valeurs.Usager;

public class MsgAjouterRendezVous extends MessageNtro {
	
	private Usager premierJoueur;

	public Usager getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Usager premierJoueur) {
		this.premierJoueur = premierJoueur;
	}

	public String ajouterA(ModeleFileAttente fileAttente) {

		return fileAttente.ajouterRendezVous(premierJoueur);
	}

}
