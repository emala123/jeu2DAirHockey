package air_hockey.frontal.controles;

import air_hockey.commun.monde2d.MondeAir_Hockey2d;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;

public class CanvasPartie extends ResizableWorld2dCanvasFx {

    @Override
    protected void initialize() {
        // ajouter
        setInitialWorldSize(MondeAir_Hockey2d.LARGEUR_MONDE, MondeAir_Hockey2d.HAUTEUR_MONDE);
    }

	public void afficherFps(String fps) {
		drawOnCanvas(gc -> {

			gc.fillText(fps, 0, 12);

		});
		
	}
}