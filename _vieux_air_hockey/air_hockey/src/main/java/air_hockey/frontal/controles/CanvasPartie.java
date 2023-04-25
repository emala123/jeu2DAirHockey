package air_hockey.frontal.controles;

import air_hockey.commun.monde2d.MondeAirHockey2d;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;

public class CanvasPartie extends ResizableWorld2dCanvasFx{

	@Override
	protected void initialize() {
		setInitialWorldSize(MondeAirHockey2d.LARGEUR_MONDE, MondeAirHockey2d.HAUTEUR_MONDE);
		
	}

	public void afficherFps(String imagesParSeconde) {
		drawOnCanvas(gc -> {
			gc.fillText(imagesParSeconde, 0, 12);
		});
	}

}
