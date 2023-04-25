package air_hockey.maquettes;

import java.util.List;
import java.util.Random;

import air_hockey.commun.maquettes.MaquetteLeaderboard;
import air_hockey.commun.valeurs.Joueur;
import ca.ntro.core.initialization.Ntro;
import ca.ntro.core.services.RandomServiceJdk;

public class MaquetteJoueurs {
	
	
	private static RandomServiceJdk ntroRandom = new RandomServiceJdk();
	
	public static boolean modeTest = true;
	
	private static Joueur joueurCourant = joueurAleatoire();

	public static boolean siJoueurLocal(Joueur joueur) {
		boolean siLocal = false;
		
		if(modeTest) {
			siLocal = true;
		}else if (joueurCourant.equals(joueur)) {
			siLocal = true;
		}
		
		return siLocal;
	}
	
	public static Joueur joueurCourant() {
		return MaquetteSession.joueurCourant;
	}
	
	public static void prochainJoueur() {
		MaquetteSession.joueurCourant = eviterRepetitionDePrenom(joueurAleatoire());
	}
	
	static Joueur joueurAleatoire() {
		Joueur joueur = new Joueur();
		joueur.setRegion(regionAleatoire());
		joueur.setPrenom(prenomAleatoire());
		joueur.setNom(nomAleatoire());
		joueur.setPoint(pointAleatoire());
		
		return joueur;
	}
	
	private static Joueur eviterRepetitionDePrenom(Joueur joueurAleatoire) {
		
		while(joueurAleatoire.getPrenom().equals(MaquetteSession.joueurCourant.getPrenom())){
			joueurAleatoire.setPrenom(prenomAleatoire());
		}
		
		return joueurAleatoire;
	}
	
	static int pointAleatoire() {
		Random rand = new Random();
		
		int nombreAleatoire = rand.nextInt(100) + 1;
		
		return nombreAleatoire;
	}
	
	static String prenomAleatoire() {
		List<String> choixDePrenoms = List.of("Alice",
									       "Bob",
									       "Chaaya",
									       "Dominic",
									       "Yourrage",
									       "Kai",
									       "Christian",
									       "Mehdi",
									       "Seb",
									       "Manu",
									       "Louis",
									       "Ichiro",
									       "Jun",
									       "Marcel");	
	
		return ntroRandom.choice(choixDePrenoms);
	}
	
	static String nomAleatoire() {
		
		List<String> choixDeNoms = List.of("Lagrois",
										   "Gonzales",
										   "Yi",
										   "Josan",
										   "Castillo",
										   "Chaussé",
										   "Lima",
										   "Heer",
										   "Jäger",
										   "Uzumaki",
										   "Uchiha",
										   "Arevalo",
										   "Augustin",
										   "Delisle");
		
		return ntroRandom.choice(choixDeNoms);
	}

	static String regionAleatoire() {
		List<String> choixRegion = MaquetteLeaderboard.partieEnCours();
		return ntroRandom.choice(choixRegion);
	}
	
	public static void initialiser(String[] args) {
		String prenom = null;
		
		if(args.length > 0) {
			prenom = args[0];
			modeTest = false;
		
		}else {
			prenom = prenomAleatoire();
		
		}
		
		joueurCourant = new Joueur(regionAleatoire(),
								   prenom,
								   nomAleatoire(),
								   pointAleatoire());
	}
}
