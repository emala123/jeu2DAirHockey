package air_hockey;

import air_hockey.commun.messages.MsgAjouterPartie;
import air_hockey.commun.modeles.ModeleHistorique;
import air_hockey.commun.modeles.valeurs.Historique;
import air_hockey.commun.modeles.valeurs.Usager;
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
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerModel(ModeleHistorique.class);
		registrar.registerValue(Usager.class);
		registrar.registerValue(Historique.class);
	}

}
