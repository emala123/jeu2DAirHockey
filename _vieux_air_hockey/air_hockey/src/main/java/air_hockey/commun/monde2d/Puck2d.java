package air_hockey.commun.monde2d;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.messages.MsgAjouterPoint;
import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.shape.ArcType;

public class Puck2d extends ObjetAirHockey2d {

	private static final double EPSILON = 15;
	
	private Pusher2d pusherGauche;
	private Pusher2d pusherDroite;

	public Pusher2d getPusherDroite() {
		return pusherDroite;
	}

	public void setPusherDroite(Pusher2d pusherDroite) {
		this.pusherDroite = pusherDroite;
	}

	public Pusher2d getPusherGauche() {
		return pusherGauche;
	}

	public void setPusherGauche(Pusher2d pusherGauche) {
		this.pusherGauche = pusherGauche;
	}
	
	public Puck2d() {
		super();
	}
	
	public Puck2d(Pusher2d pusherGauche, Pusher2d pusherDroite) {
		super();
		
		setPusherGauche(pusherGauche);
		setPusherDroite(pusherDroite);
	}

	@Override
	public void initialize() {
		setWidth(25);
		setHeight(25);
		
		choisirEtatInitial();
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
		return "puck";
	}
	
	public boolean puckFrappePusher(Pusher2d pusher) {
		return collidesWith(pusher);
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		
		super.onTimePasses(secondsElapsed);
		
		if(balleFrappeMurGauche()) {
			
			balleRebondiSurMurGauche();
			choisirEtatInitial();
            ajouterPoint(Cadran.DROITE);
			
		}else if (balleFrappeMurDroit()) {
			
			balleRebondiSurMurDroit();
			choisirEtatInitial();
            ajouterPoint(Cadran.GAUCHE);
			
		}else if(balleFrappePlafond()) {

            balleRebondiSurPlafond();

        }else if(balleFrappePlancher()) {

            balleRebondiSurPlancher();
            
        }else if (puckFrappePusher(pusherGauche)) {
        	
        	puckRebondiSurPusher(pusherGauche);
        	
        }else if (puckFrappePusher(pusherDroite)) {
        	
        	puckRebondiSurPusher(pusherDroite);
        	
        }
	}
	
	private void puckRebondiSurPusher(Pusher2d pusher) {
		
		if(getTopLeftX() < pusher.getTopLeftX()) {
			
			setTopLeftX(pusher.getTopLeftX() - getWidth() - 1);
			
		}else {
			
			setTopLeftX(pusher.getTopLeftX() + pusher.getWidth() + 1);
			
		}
		
		setSpeedX(-getSpeedX());
	}

	private boolean balleFrappeMurGauche() {
		return collidesWith(0,
							0,
							1,
							getWorld2d().getHeight());
	}

	private void balleRebondiSurMurGauche() {
		setTopLeftX(0 + EPSILON);
        setSpeedX(-getSpeedX());
		
	}

	private boolean balleFrappeMurDroit() {
		return collidesWith(getWorld2d().getWidth(),
							0,
							1,
							getWorld2d().getHeight());
	}

	private void balleRebondiSurMurDroit() {
		setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
        setSpeedX(-getSpeedX());
		
	}

	private boolean balleFrappePlafond() {
		return collidesWith(0,
						0,
						getWorld2d().getWidth(),
						1);
	}

	private void balleRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
		
	}

	private boolean balleFrappePlancher() {
		return collidesWith(0,
							getWorld2d().getHeight(),
							getWorld2d().getWidth(),
							1);
	}

	private void balleRebondiSurPlancher() {
		setTopLeftY(getWorld2d().getHeight()- this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
		
	}
	
	private void choisirEtatInitial() {
		
		setTopLeftY(10);
        setSpeedY(100 + Ntro.random().nextInt(20));

        if(Ntro.random().nextBoolean()) {

            setTopLeftX(100);
            setSpeedX(100 + Ntro.random().nextInt(20));

        }else {

            setTopLeftX(MondeAirHockey2d.LARGEUR_MONDE - 100 - getWidth());
            setSpeedX(-100 - Ntro.random().nextInt(20));

        }
	}
	
	private void ajouterPoint(Cadran cadran) {
		
		MsgAjouterPoint msgAjouterPoint = NtroApp.newMessage(MsgAjouterPoint.class);
        msgAjouterPoint.setMondeAirHockey2d(getWorld2d());
        msgAjouterPoint.setCadran(cadran.name());
        msgAjouterPoint.send();
		
	}
}
