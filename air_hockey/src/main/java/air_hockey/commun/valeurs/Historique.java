package air_hockey.commun.valeurs;

import air_hockey.frontal.fragments.FragmentPartie;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;

public class Historique implements ModelValue {

	private Usager Joueur1;
	private Usager Joueur2;

	private String idPartie;

	public FragmentPartie creerFragment(ViewLoader<FragmentPartie> viewLoaderPartie) {

		return viewLoaderPartie.createView();
	}
	
	public void afficherSur(FragmentPartie fragmentPartie) {
		fragmentPartie.afficherNomPremierJoueur(Joueur1.nomComplet());
		fragmentPartie.afficherNomDeuxiemeJoueur(Joueur2.nomComplet());
		fragmentPartie.memoriserIdPartie(idPartie);
    }
	
	public Historique() {
		super();
	}

	public Historique(String idPartie, Usager premierJoueur, Usager deuxiemeJoueur) {
		setIdPartie( idPartie);
		setJoueur1(premierJoueur);
		setJoueur2(deuxiemeJoueur);
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
		return Joueur1.nomComplet() + " Vs " + Joueur2.nomComplet();

	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}

}
