package air_hockey.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import air_hockey.commun.enums.Action;
import air_hockey.commun.enums.Cadran;

public class MondeAir_Hockey2d extends World2dFx /* <ObjetPong2d, MondePong2d> */ {

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;

	private Poussoir2d poussoirGauche;
	private Poussoir2d poussoirDroite;
	private Puck2d puck;


	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);

		poussoirGauche = new Poussoir2d(25);
		poussoirDroite = new Poussoir2d(LARGEUR_MONDE - 35);
		puck = new Puck2d(poussoirGauche, poussoirDroite);

		addObject2d(poussoirGauche);
		addObject2d(poussoirDroite);
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
		gc.setStroke(Color.LIGHTGREY);
		gc.setLineWidth(1);

		gc.strokeRect(0, 0, getWidth(), getHeight());

		gc.restore();
	}

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void appliquerActionJoueur(Cadran cadran, Action action) {
		Poussoir2d poussoir = poussoirDuCadran(cadran);

		appliquerActionJoueur(poussoir, action);
	}

	private Poussoir2d poussoirDuCadran(Cadran cadran) {
		Poussoir2d poussoir;

		switch (cadran) {
		case GAUCHE:
		default:
			poussoir = poussoirGauche;
			break;

		case DROITE:
			poussoir = poussoirDroite;
			break;
		}

		return poussoir;
	}

	private void appliquerActionJoueur(Poussoir2d poussoir, Action action) {

		switch (action) {
		case HAUT:
			poussoir.monter();
			break;

		case BAS:
			poussoir.descendre();
			break;

		case ARRET:
		default:
			poussoir.arreter();
		}
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

	public Puck2d getPuck() {
		return puck;
	}

	public void setPuck(Puck2d puck) {
		this.puck = puck;
	}
}