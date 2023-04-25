package air_hockey.maquettes;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.valeurs.Joueur;

public class MaquetteSession {

	public static boolean modeTest = true;
	
	static String regionCourante = MaquetteJoueurs.regionAleatoire();
	static Joueur joueurCourant = MaquetteJoueurs.joueurAleatoire();
	private static Cadran cadranCourant = Cadran.DROITE;
	
	public static Joueur joueurCourant() {
		return joueurCourant;
	}
	
	public static String regionCourant() {
		return regionCourante;
	}
	
	public static boolean siOnPeutJouerGauche() {
		return cadranCourant == Cadran.GAUCHE
				|| cadranCourant == Cadran.LES_DEUX;
	}
	
	public static boolean siOnPeutJouerDroite() {
		return cadranCourant == Cadran.DROITE
				|| cadranCourant == Cadran.LES_DEUX;
	}
	
	public static void initialiser(String[] args) {
		String region = null;
		String prenom = null;
		String nom = null;
		int point;
		
		if (args.length > 0) {
			region = args[0];
			modeTest = false;
		}else {
			region = MaquetteJoueurs.regionAleatoire();
		}
		if(args.length > 1) {
			prenom = args[1];
		}else {
			prenom = MaquetteJoueurs.prenomAleatoire();
		}
		
		if(args.length > 2) {
			nom = args[2];
		}else {
			nom = MaquetteJoueurs.nomAleatoire();
		}
		
		if(args.length > 3) {
			point = Integer.parseInt(args[3]);
		}else {
			point = MaquetteJoueurs.pointAleatoire();
		}
		
		joueurCourant = new Joueur(region, prenom, nom, point);
	}
}
