package pong.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.commun.messages.MsgAjouterPoint;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.messages.MsgRetirerRendezVous;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.modeles.ModelePartie;
import pong.commun.monde2d.Balle2d;
import pong.commun.monde2d.MondePong2d;
import pong.commun.monde2d.Palette2d;
import pong.commun.valeurs.PartieEnCours;
import pong.commun.valeurs.RendezVous;
import pong.commun.valeurs.Usager;


public class Declarations {

    public static void declarerMessages(MessageRegistrar registrar) {

        registrar.registerMessage(MsgAjouterRendezVous.class);
        registrar.registerMessage(MsgRetirerRendezVous.class);
        registrar.registerMessage(MsgAjouterPoint.class);
    }

    public static void declarerModeles(ModelRegistrar registrar) {

        registrar.registerModel(ModeleFileAttente.class);
        registrar.registerValue(RendezVous.class);
        registrar.registerValue(PartieEnCours.class);
        registrar.registerValue(Usager.class);
        registrar.registerModel(ModelePartie.class);
        registrar.registerValue(MondePong2d.class);
        registrar.registerValue(Balle2d.class);
        registrar.registerValue(Palette2d.class);
    }

    public static void declarerServeur(ServerRegistrar registrar) {
        // ajouter
        registrar.registerName("localhost");

        // ajouter
        registrar.registerPort(8002);
    }
}
