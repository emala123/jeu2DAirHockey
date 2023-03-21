package air_hockey.commun.messages;

import air_hockey.commun.modeles.ModeleHistorique;
import ca.ntro.app.messages.MessageNtro;

public class MsgRetirerPartie extends MessageNtro {
    
    private String idPartie;

    public String getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(String idPartie) {
        this.idPartie = idPartie;
    }

    public void retirerDe(ModeleHistorique historique) {
    	historique.retirerPartie(idPartie);
    }
}