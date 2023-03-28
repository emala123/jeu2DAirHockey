package pong.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.shape.ArcType;
import ca.ntro.core.initialization.Ntro;

public class Balle2d extends ObjetPong2d {

	private static final double EPSILON = 1;
	
    public Balle2d() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(100);
        setTopLeftY(100);
        
     // ajouter
        setSpeedX(100 + Ntro.random().nextInt(100));
        setSpeedY(100 + Ntro.random().nextInt(100));
        
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {

        canvas.drawOnWorld(gc -> {

            gc.fillArc(getTopLeftX(),
                       getTopLeftY(),
                       getWidth(), 
                       getHeight(), 
                       0, 
                       360, 
                       ArcType.CHORD);
        });
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

    @Override
    public String id() {
        return "balle";
    }
    
 // ajouter
    @Override
    public void onTimePasses(double secondsElapsed) {
        super.onTimePasses(secondsElapsed);

        if(balleFrappeMurGauche()) {

            balleRebondiSurMurGauche();

        }else if(balleFrappeMurDroit()) {

            balleRebondiSurMurDroit();

        }else if(balleFrappePlafond()) {

            balleRebondiSurPlafond();

        }else if(balleFrappePlancher()) {

            balleRebondiSurPlancher();
        }
    }
    
    private boolean balleFrappePlancher() {
        return collidesWith(0,
                            getWorld2d().getHeight(),
                            getWorld2d().getWidth(),
                            1);
    }

    private boolean balleFrappePlafond() {
        return collidesWith(0,
                            0,
                            getWorld2d().getWidth(),
                            1);
    }

    private boolean balleFrappeMurDroit() {
        return collidesWith(getWorld2d().getWidth(),
                            0,
                            1,
                            getWorld2d().getHeight());
    }

    private boolean balleFrappeMurGauche() {
        return collidesWith(0,
                            0,
                            1,
                            getWorld2d().getHeight());
    }

    private void balleRebondiSurPlancher() {
        setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurPlafond() {
        setTopLeftY(0 + EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurMurDroit() {
        setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
        setSpeedX(-getSpeedX());
    }

    private void balleRebondiSurMurGauche() {
        setTopLeftX(0 + EPSILON);
        setSpeedX(-getSpeedX());
    }
    
}