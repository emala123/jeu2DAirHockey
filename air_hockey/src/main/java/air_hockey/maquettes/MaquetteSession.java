package air_hockey.maquettes;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.valeurs.Usager;

public class MaquetteSession {

	public static boolean modeTest = true;

	static Usager usagerCourant = MaquetteUsagers.usagerAleatoire();
	private static Cadran cadranCourant = Cadran.DROITE;

	public static Usager usagerCourant() {
		return usagerCourant;
	}

	public static boolean siOnPeutJouerGauche() {
		return cadranCourant == Cadran.GAUCHE || cadranCourant == Cadran.LES_DEUX;

	}

	public static boolean siOnPeutJouerDroite() {
		return cadranCourant == Cadran.DROITE || cadranCourant == Cadran.LES_DEUX;

	}

	public static void memoriserCadranCourant(String idPremierJoueur, String idDeuxiemeJoueur) {

		if (idPremierJoueur.equals(usagerCourant.getId())) {

			cadranCourant = Cadran.GAUCHE;

		} else if (idDeuxiemeJoueur.equals(usagerCourant.getId())) {

			cadranCourant = Cadran.DROITE;

		} else {

			cadranCourant = Cadran.LES_DEUX;
		}
	}

	public static void initialiser(String[] args) {
		String id = null;
		String prenom = null;
		String nom = null;
		int pointage = 0;

		if (args.length > 0) {
			id = args[0];
			modeTest = false;
		} else {
			id = MaquetteUsagers.idAleatoire();
		}

		if (args.length > 1) {
			prenom = args[1];
		} else {
			prenom = MaquetteUsagers.prenomAleatoire();
		}

		if (args.length > 2) {
			nom = args[2];
		} else {
			nom = MaquetteUsagers.nomAleatoire();
		}
		if (args.length > 3) {
			pointage = Integer.parseInt(args[3]);
		} else {
			pointage = MaquetteUsagers.pointageAleatoire();
		}

		usagerCourant = new Usager(id, prenom, nom, pointage);
	}

}