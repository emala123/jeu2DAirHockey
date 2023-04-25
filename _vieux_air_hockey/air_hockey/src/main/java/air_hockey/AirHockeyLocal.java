package air_hockey;


import air_hockey.commun.Declarations;
import air_hockey.commun.valeurs.TouchesActives;
import air_hockey.commun.valeurs.TouchesActivesParCadran;
import air_hockey.dorsal.DorsalAir_Hockey;
import air_hockey.frontal.FrontalAir_Hockey;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class AirHockeyLocal implements NtroClientFx{

	public static void main(String[] args) {
		NtroClientFx.launch(args);

	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(new DorsalAir_Hockey());
		
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
		
		registrar.registerValue(TouchesActives.class);
		registrar.registerValue(TouchesActivesParCadran.class);

	}

}
