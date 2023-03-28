package pong.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import pong.commun.monde2d.MondePong2d;

public class CanvasPartie extends ResizableWorld2dCanvasFx {

    @Override
    protected void initialize() {

    	 setInitialWorldSize(MondePong2d.LARGEUR_MONDE, MondePong2d.HAUTEUR_MONDE);

    }

	public void afficherFps(String fps) {
		// TODO Auto-generated method stub
		drawOnCanvas(gc -> {

			gc.fillText(fps, 0, 12);

		});
	}
}