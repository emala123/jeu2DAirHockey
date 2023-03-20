package pong.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import pong.commun.modeles.ModeleFileAttente;

public class MsgRetirerRendezVous extends MessageNtro {
    
    private String idRendezVous;

    public String getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(String idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public void retirerDe(ModeleFileAttente fileAttente) {
        fileAttente.retirerRendezVous(idRendezVous);
    }
}
