package air_hockey;

import air_hockey.commun.Declarations;
import air_hockey.dorsal.DorsalAirHockeyDistant;
import air_hockey.frontal.FrontalAir_Hockey;
import air_hockey.maquettes.MaquetteSession;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class ClientAirHockey implements NtroClientFx{

	public static void main(String[] args) {
		
		MaquetteSession.initialiser(args);
		
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalAirHockeyDistant());
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalAir_Hockey());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		Declarations.declarerModeles(registrar);
		
	}
}
