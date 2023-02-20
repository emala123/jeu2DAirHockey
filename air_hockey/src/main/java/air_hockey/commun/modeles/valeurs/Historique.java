package air_hockey.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;

public class Historique implements ModelValue {


	private Usager Joueur1;
	private Usager Joueur2;

	public Historique() {
		super();
	}

	public Usager getJoueur2() {
		return Joueur2;
	}

	public void setJoueur2(Usager joueur2) {
		Joueur2 = joueur2;
	}

	public Usager getJoueur1() {
		return Joueur1;
	}

	public void setJoueur1(Usager joueur1) {
		Joueur1 = joueur1;
	}

	@Override
	public String toString() {
		return Joueur1.nomComplet() +" Vs " +Joueur2.nomComplet();
		
	}


}
