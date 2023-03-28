package air_hockey;

import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.messages.MsgAjouterPoint;
import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.ModelePartie;
import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import air_hockey.commun.monde2d.Poussoir2d;
import air_hockey.commun.monde2d.Puck2d;
import air_hockey.commun.valeurs.Historique;
import air_hockey.commun.valeurs.Usager;
import air_hockey.dorsal.DorsalAirHockey;
import air_hockey.frontal.FrontalAirHockey;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class AirHockeyLocal implements NtroClientFx{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NtroClientFx.launch(args);
	}
	
	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerBackend(new DorsalAirHockey());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerFrontend(new FrontalAirHockey());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerMessage(MsgAjouterPartie.class);
		registrar.registerMessage(MsgAjouterPoint.class);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerModel(ModeleHistorique.class);
		registrar.registerValue(Usager.class);
		registrar.registerValue(Historique.class);
		registrar.registerModel(ModelePartie.class);
		registrar.registerValue(MondeAir_Hockey2d.class);
		registrar.registerValue(Puck2d.class);
		registrar.registerValue(Poussoir2d.class);
	}

}
