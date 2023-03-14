package pong.commun.modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;

public class PartieEnCours extends RendezVous {

	private Usager deuxiemeJoueur;
    private String idPartie;
	
    public PartieEnCours(){
        super();
    }
    
    @Override
    public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous, 
            ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {

		return viewLoaderPartieEnCours.createView();
	}
    
    public void afficherSur(FragmentRendezVous fragmentRendezVous) {
        super.afficherSur(fragmentRendezVous);
        
        FragmentPartieEnCours fragmentPartieEnCours = (FragmentPartieEnCours) fragmentRendezVous;
        fragmentPartieEnCours.afficherNomDeuxiemeJoueur(deuxiemeJoueur.getPrenom());
    }
   
	public Usager getDeuxiemeJoueur() {
		return deuxiemeJoueur;
	}

	public void setDeuxiemeJoueur(Usager deuxiemeJoueur) {
		this.deuxiemeJoueur = deuxiemeJoueur;
	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	@Override
    public String toString() {
        return getPremierJoueur().getPrenom() + " Vs " + deuxiemeJoueur.getPrenom();
    }
	
}