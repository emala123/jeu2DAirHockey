package pong.commun.modeles.valeurs;

public class PartieEnCours extends RendezVous {

	private Usager deuxiemeJoueur;
    private String idPartie;
	
    public PartieEnCours(){
        super();
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