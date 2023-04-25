package air_hockey.commun.monde2d;

import air_hockey.commun.enums.Cadran;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Pusher2d extends ObjetAirHockey2d{

	private static final double VITESSE_PUSHER = 200;
	
	public Pusher2d() {
		super();
	}
	
	public Pusher2d(double topLeftX) {
		super();
		
		setTopLeftX(topLeftX);
	}

	@Override
	public void initialize() {
		setWidth(40);
		setHeight(40);
		
		setTopLeftY(getWorld2d().getHeight()/2 - getHeight()/2);
	}
	
	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
		
		canvas.drawOnWorld(gc -> {
			
			gc.save();
			
			gc.setFill(Color.DARKRED);
			
			gc.fillArc(getTopLeftX(),
					   getTopLeftY(),
					   getWidth(),
					   getHeight(),
					   0,
					   360,
					   ArcType.ROUND);
			
			gc.restore();
		});
		
		canvas.drawOnWorld(gc -> {
			
			gc.save();
			
			gc.setFill(Color.BLACK);
			
			gc.fillArc(getTopLeftX()+5,
					   getTopLeftY()+5,
					   getWidth()-10,
					   getHeight()-10,
					   0,
					   360,
					   ArcType.CHORD);
			
		
			
			gc.restore();
		});
		
		canvas.drawOnWorld(gc -> {
			
			gc.save();
			
			gc.setFill(Color.RED);
			
			gc.fillArc(getTopLeftX()+10,
					   getTopLeftY()+10,
					   getWidth()-20,
					   getHeight()-20,
					   0,
					   360,
					   ArcType.CHORD);
			
		
			
			gc.restore();
		});
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}


	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void monter() {
		setSpeedY(-VITESSE_PUSHER);
	}
	
	public void descendre() {
		setSpeedY(+VITESSE_PUSHER);
	}
	
	public void droite() {
		setSpeedX(+VITESSE_PUSHER);
	}
	
	public void gauche() {
		setSpeedX(-VITESSE_PUSHER);
	}
	
	public void arreter() {
		setSpeedY(0);
		setSpeedX(0);
	}
}
