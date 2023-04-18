package air_hockey;

import air_hockey.commun.Declarations;
import air_hockey.dorsal.DorsalAirHockey;
import air_hockey.frontal.FrontalAirHockey;
import air_hockey.maquettes.MaquetteSession;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class AirHockeyLocal implements NtroClientFx{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquetteSession.initialiser(args);
		
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
		Declarations.declarerMessages(registrar);
	}

    @Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerModeles(registrar);
	}

}
