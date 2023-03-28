package air_hockey.commun.monde2d;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.messages.MsgAjouterPoint;
import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.shape.ArcType;

public class Puck2d extends ObjetAir_Hockey2d {

	private static final double EPSILON = 1;

	private Poussoir2d poussoirGauche;
    private Poussoir2d poussoirDroite;
	
	public Puck2d() {
		super();
	}

	public Puck2d( Poussoir2d poussoirGauche, Poussoir2d poussoirDroite) {
        super();

        setPoussoirGauche(poussoirGauche);
        setPoussoirDroite(poussoirDroite);
    }
	
	@Override
	public void initialize() {
		setWidth(10);
        setHeight(10);

        choisirEtatInitial();
	}

	private void choisirEtatInitial() {

        setTopLeftY(10);
        setSpeedY(100 + Ntro.random().nextInt(20));

        if(Ntro.random().nextBoolean()) {

            setTopLeftX(100);
            setSpeedX(100 + Ntro.random().nextInt(20));

        }else {

            setTopLeftX(MondeAir_Hockey2d.LARGEUR_MONDE - 100 - getWidth());
            setSpeedX(-100 - Ntro.random().nextInt(20));

        }
    }
	
	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {

		canvas.drawOnWorld(gc -> {

			gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360, ArcType.CHORD);
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

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (balleFrappeMurGauche()) {

			balleRebondiSurMurGauche();
			 choisirEtatInitial();
	            ajouterPoint(Cadran.DROITE);
		} else if (balleFrappeMurDroit()) {

			balleRebondiSurMurDroit();
			 choisirEtatInitial();
	            ajouterPoint(Cadran.GAUCHE);
		} else if (balleFrappePlafond()) {

			balleRebondiSurPlafond();

		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();
		}else if(balleFrappePoussoir(poussoirGauche)) {

			balleRebondiSurPoussoir(poussoirGauche);

        }else if(balleFrappePoussoir(poussoirDroite)) {

        	balleRebondiSurPoussoir(poussoirDroite);

        }
	}
	
	private boolean balleFrappePlancher() {
		return collidesWith(0, getWorld2d().getHeight(), getWorld2d().getWidth(), 1);
	}

	private boolean balleFrappePlafond() {
		return collidesWith(0, 0, getWorld2d().getWidth(), 1);
	}

	private boolean balleFrappeMurDroit() {
		return collidesWith(getWorld2d().getWidth(), 0, 1, getWorld2d().getHeight());
	}

	private boolean balleFrappeMurGauche() {
		return collidesWith(0, 0, 1, getWorld2d().getHeight());
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
	
	private boolean balleFrappePoussoir(Poussoir2d poussoir) {
        return collidesWith(poussoir);
    }

	
	 private void balleRebondiSurPoussoir(Poussoir2d poussoir) {

	        if(getTopLeftX() < poussoir.getTopLeftX()) {

	            setTopLeftX(poussoir.getTopLeftX() - getWidth() - EPSILON);

	        } else {

	            setTopLeftX(poussoir.getTopLeftX() + poussoir.getWidth() + EPSILON);

	        }

	        setSpeedX(-getSpeedX());
	    }
	
	private void ajouterPoint(Cadran cadran) {
        MsgAjouterPoint msgAjouterPoint = NtroApp.newMessage(MsgAjouterPoint.class);
        msgAjouterPoint.setMondeAir_Hockey2d(getWorld2d());
        msgAjouterPoint.setCadran(cadran.name());
        msgAjouterPoint.send();
    }

	public Poussoir2d getPoussoirGauche() {
		return poussoirGauche;
	}

	public void setPoussoirGauche(Poussoir2d poussoirGauche) {
		this.poussoirGauche = poussoirGauche;
	}

	public Poussoir2d getPoussoirDroite() {
		return poussoirDroite;
	}

	public void setPoussoirDroite(Poussoir2d poussoirDroite) {
		this.poussoirDroite = poussoirDroite;
	}
	
}
