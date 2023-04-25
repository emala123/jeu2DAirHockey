package air_hockey.commun.monde2d;

import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MondeAirHockey2d  extends World2dFx{

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;
	
	private Pusher2d pusherGauche;
	private Pusher2d pusherDroite;
	private Puck2d puck;
	
	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);
		
		pusherGauche = new Pusher2d(25);
		pusherDroite = new Pusher2d(LARGEUR_MONDE - 60);
		puck = new Puck2d(pusherGauche, pusherDroite);
		
		addObject2d(pusherGauche);
		addObject2d(pusherDroite);
		addObject2d(puck);
		
	}
	
	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
		canvas.drawOnWorld(gc -> {
			dessinerTerrain(gc);
		});
		
		super.drawOn(canvas);
	}
	
	private void dessinerTerrain(GraphicsContext gc) {
		gc.save();
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(15);
		
		gc.strokeRect(0, 0, getWidth(), getHeight());
		
		gc.restore();
	}

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		
	}

	public void appliquerActionJoueur(Cadran cadran, Action action) {
		Ntro.logger().info("Monde2d.action: " + action);

		Pusher2d pusher = pusherDuCadran(cadran);
		
		appliquerActionJoueur(pusher, action);
		
	}
	
	private Pusher2d pusherDuCadran(Cadran cadran) {

		Pusher2d pusher;
		
		switch(cadran) {
		case GAUCHE:
			default:
				pusher = pusherGauche;
				break;
			case DROITE:
				pusher = pusherDroite;
				break;
		}
		
		return pusher;
	}
	
	private void appliquerActionJoueur(Pusher2d pusher, Action action) {


		switch(action) {
		case HAUT:
			pusher.arreter();
			pusher.monter();
			break;
		case DROITE:
			pusher.arreter();
			pusher.droite();
			break;
		case BAS:
			pusher.arreter();
			pusher.descendre();
			break;
		case GAUCHE:
			pusher.arreter();
			pusher.gauche();
			break;
		case DIAGONALHAUTDROITE:
			pusher.monter();
			pusher.droite();
			break;
		case DIAGONALHAUTGAUCHE:
			pusher.monter();
			pusher.gauche();
			break;
		case DIAGONALBASDROITE:
			pusher.descendre();
			pusher.droite();
			break;
		case DIAGONALBASGAUCHE:
			pusher.descendre();
			pusher.gauche();
			break;
		case ARRET:
			default:

				pusher.arreter();
				break;


		}
	}

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

}
