package pong.commun.monde2d;

import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.shape.ArcType;
import pong.commun.enums.Cadran;
import pong.commun.messages.MsgAjouterPoint;

public class Balle2d extends ObjetPong2d {

	private Palette2d paletteGauche;
	private Palette2d paletteDroite;

	public Balle2d() {
		super();
	}

	public Balle2d(Palette2d paletteGauche, Palette2d paletteDroite) {
		super();

		setPaletteGauche(paletteGauche);
		setPaletteDroite(paletteDroite);
	}

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

	private static final double EPSILON = 1;

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(10);
		// setTopLeftX(100);
		// setTopLeftY(100);
		choisirEtatInitial();
		// setSpeedX(100 + Ntro.random().nextInt(100));
		// setSpeedY(100 + Ntro.random().nextInt(100));
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
		return "balle";
	}

	private void choisirEtatInitial() {

		setTopLeftY(10);
		setSpeedY(100 + Ntro.random().nextInt(20));

		if (Ntro.random().nextBoolean()) {

			setTopLeftX(100);
			setSpeedX(100 + Ntro.random().nextInt(20));

		} else {

			setTopLeftX(MondePong2d.LARGEUR_MONDE - 100 - getWidth());
			setSpeedX(-100 - Ntro.random().nextInt(20));

		}
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (balleFrappeMurGauche()) {

			choisirEtatInitial();
			ajouterPoint(Cadran.DROITE);

		} else if (balleFrappeMurDroit()) {

			choisirEtatInitial();
			ajouterPoint(Cadran.GAUCHE);

		} else if (balleFrappePlafond()) {

			balleRebondiSurPlafond();

		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();

		} else if (balleFrappePalette(paletteGauche)) {

			balleRebondiSurPalette(paletteGauche);

		} else if (balleFrappePalette(paletteDroite)) {

			balleRebondiSurPalette(paletteDroite);

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

	private boolean balleFrappePalette(Palette2d palette) {
		return collidesWith(palette);
	}

	private void balleRebondiSurPalette(Palette2d palette) {

		if (getTopLeftX() < palette.getTopLeftX()) {

			setTopLeftX(palette.getTopLeftX() - getWidth() - EPSILON);

		} else {

			setTopLeftX(palette.getTopLeftX() + palette.getWidth() + EPSILON);

		}

		setSpeedX(-getSpeedX());
	}

	private void ajouterPoint(Cadran cadran) {
		MsgAjouterPoint msgAjouterPoint = NtroApp.newMessage(MsgAjouterPoint.class);
		msgAjouterPoint.setMondePong2d(getWorld2d());
		msgAjouterPoint.setCadran(cadran.name());
		msgAjouterPoint.send();
	}

}