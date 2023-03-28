package pong.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pong.commun.enums.Action;
import pong.commun.enums.Cadran;

public class MondePong2d extends World2dFx /* <ObjetPong2d, MondePong2d> */ {

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;

	private Palette2d paletteGauche;
	private Palette2d paletteDroite;
	private Balle2d balle;

	public Palette2d getPaletteGauche() {
		return paletteGauche;
	}

	public void setPaletteGauche(Palette2d paletteGauche) {
		this.paletteGauche = paletteGauche;
	}

	public Palette2d getPaletteDroite() {
		return paletteDroite;
	}

	public void setPaletteDroite(Palette2d paletteDroite) {
		this.paletteDroite = paletteDroite;
	}

	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);

		paletteGauche = new Palette2d(25);
		paletteDroite = new Palette2d(LARGEUR_MONDE - 35);
		balle = new Balle2d(paletteGauche, paletteDroite);

		addObject2d(paletteGauche);
		addObject2d(paletteDroite);
		addObject2d(balle);
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
		Palette2d palette = paletteDuCadran(cadran);

		appliquerActionJoueur(palette, action);
	}

	private Palette2d paletteDuCadran(Cadran cadran) {
		Palette2d palette;

		switch (cadran) {
		case GAUCHE:
		default:
			palette = paletteGauche;
			break;

		case DROITE:
			palette = paletteDroite;
			break;
		}

		return palette;
	}

	private void appliquerActionJoueur(Palette2d palette, Action action) {

		switch (action) {
		case HAUT:
			palette.monter();
			break;

		case BAS:
			palette.descendre();
			break;

		case ARRET:
		default:
			palette.arreter();
		}
	}
}