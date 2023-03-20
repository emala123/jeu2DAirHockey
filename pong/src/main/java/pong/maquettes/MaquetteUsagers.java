package pong.maquettes;

import java.util.List;

import ca.ntro.core.initialization.Ntro;
import pong.commun.valeurs.Usager;

public class MaquetteUsagers {
	
	public static boolean modeTest = true;
	
	private static Usager usagerCourant = usagerAleatoire();
	
	public static boolean siUsagerLocal(Usager usager) {
		boolean siLocal = false;
		
		if(modeTest) {

			siLocal = true;

		}else if(usagerCourant.equals(usager)) {
			
			siLocal = true;
		}

		return siLocal;
	}

	public static Usager usagerCourant() {
		return usagerCourant;
	}

	public static void prochainUsager() {
		usagerCourant = eviterRepetitionDePrenom(usagerAleatoire());
	}

	private static Usager usagerAleatoire() {
		Usager usager = new Usager();
		
		usager.setId(idAleatoire());
		usager.setPrenom(prenomAleatoire());
		usager.setNom(nomAleatoire());
		
		return usager;
	}

	private static Usager eviterRepetitionDePrenom(Usager usagerAleatoire) {

		while(usagerAleatoire.getPrenom().equals(usagerCourant.getPrenom())) {

			usagerAleatoire.setPrenom(prenomAleatoire());
		}
		
		return usagerAleatoire;
	}


	private static String idAleatoire() {
		return Ntro.random().nextId(4);
	}
	
	private static String prenomAleatoire() {

		List<String> choixDeNoms = List.of("Alice", 
				                           "Bob", 
				                           "Chaaya", 
				                           "Dominic", 
				                           "Élisabeth", 
				                           "Firas", 
				                           "Gregson",
				                           "Mehdi",
				                           "Louis",
				                           "Marcel",
				                           "Ashwin",
				                           "Ichiro",
				                           "Jun");

		return Ntro.random().choice(choixDeNoms);
	}

	private static String nomAleatoire() {

		List<String> choixDeNoms = List.of("Abdenouri", 
				                           "Ahmadi", 
				                           "Augustin", 
				                           "Chaussé", 
				                           "Delisle", 
				                           "Heer", 
				                           "Lagrois",
				                           "Daverna",
				                           "Gonzales",
				                           "Medjoubi",
				                           "Castillo",
				                           "Josan",
				                           "Yi");

		return Ntro.random().choice(choixDeNoms);
	}

	public static void initialiser(String[] args) {
		String prenom = null;

		if(args.length > 0) {

			prenom = args[0];
			modeTest = false;

		}else {
			
			prenom = prenomAleatoire();
			
		}

		usagerCourant = new Usager(idAleatoire(), 
				                   prenom, 
				                   nomAleatoire());
	}

}
