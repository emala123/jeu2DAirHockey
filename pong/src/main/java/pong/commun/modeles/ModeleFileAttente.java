package pong.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import pong.commun.modeles.valeurs.RendezVous;

public class ModeleFileAttente implements Model, Watch, WriteObjectGraph {

    private long prochainIdRendezVous = 1;

    private List<RendezVous> lesRendezVous = new ArrayList<>();
    
    public long getProchainIdRendezVous() {
        return prochainIdRendezVous;
    }

    public void setProchainIdRendezVous(long prochainIdRendezVous) {
        this.prochainIdRendezVous = prochainIdRendezVous;
    }
    
    public ModeleFileAttente() {

    }

	public List<RendezVous> getLesRendezVous() {
		return lesRendezVous;
	}

	public void setLesRendezVous(List<RendezVous> lesRendezVous) {
		this.lesRendezVous = lesRendezVous;
	}
    
}