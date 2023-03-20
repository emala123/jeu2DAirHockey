package pong.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CanvasPartie extends ResizableWorld2dCanvasFx {

	 // ajouter
    private Image logo;
    
    @Override
    protected void initialize() {

        logo = new Image("/logo.png");

        // ajouter
        onRedraw(() -> {
            dessinerLeMonde2d();
        });
    }

    // ajouter
    private void dessinerLeMonde2d() {
        drawOnWorld(gc -> {

            gc.setFill(Color.web("#9d4024"));

            gc.fillRect(0,
                        0, 
                        getWorldWidth(), 
                        getWorldHeight());

            gc.setFill(Color.DARKGRAY);

            gc.fillArc(getWorldWidth() / 2 - 100, 
                       getWorldHeight() /2 - 100,
                       200,
                       200, 
                       0, 
                       360, 
                       ArcType.CHORD);

            gc.drawImage(logo, 
                         getWorldWidth() / 2 - logo.getWidth() / 2,
                         getWorldHeight() / 2 - logo.getHeight() / 2);


        });
    }
}