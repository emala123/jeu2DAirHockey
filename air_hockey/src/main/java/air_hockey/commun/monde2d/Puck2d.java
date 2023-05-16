package air_hockey.commun.monde2d;

import air_hockey.commun.enums.Cadran;
import air_hockey.commun.messages.MsgAjouterPoint;
import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.ArcType;
import javafx.scene.media.AudioClip;

public class Puck2d extends ObjetAirHockey2d {

	private static final double EPSILON = 15;

	private Pusher2d pusherGauche;
	private Pusher2d pusherDroite;
	private But2d butGauche;
	private But2d butDroite;

	private Image image = new Image("/puck.png");

	private AudioClip sonPuck = new AudioClip(Puck2d.class.getResource("/bruitpuck.wav").toString());

	private AudioClip sonBut = new AudioClip(Puck2d.class.getResource("/bruitbutmarque.wav").toString());

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

	public Puck2d(Pusher2d pusherGauche, Pusher2d pusherDroite, But2d butGauche, But2d butDroite) {
		super();

		setPusherGauche(pusherGauche);
		setPusherDroite(pusherDroite);
		setButGauche(butGauche);
		setButDroite(butDroite);
	}

	private void jouerSonPuck() {
		sonPuck.play();
	}

	private void jouerSonBut() {
		sonBut.play();
	}

	@Override
	public void initialize() {
		setWidth(25);
		setHeight(25);

		choisirEtatInitial();
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {

		// canvas.drawOnWorld(gc -> {

		/*
		 * gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360,
		 * ArcType.CHORD);
		 */

		gc.drawImage(image, getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

		// });
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

		if (balleFrappeMilieuMurGauche()) {

			balleRebondiSurMilieuMurGauche();
			choisirEtatInitial();
			ajouterPoint(Cadran.DROITE);
			jouerSonBut();

		} else if (balleFrappeMilieuMurDroit()) {

			balleRebondiSurMilieuMurDroit();
			choisirEtatInitial();
			ajouterPoint(Cadran.GAUCHE);
			jouerSonBut();

		} else if (balleFrappeMurGauche()) {

			balleRebondiSurMurGauche();

		} else if (balleFrappeMurDroit()) {

			balleRebondiSurMurDroit();

		} else if (balleFrappePlafond()) {

			balleRebondiSurPlafond();

		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();

		} else if (puckFrappePusher(pusherGauche)) {

			puckRebondiSurPusher(pusherGauche);

		} else if (puckFrappePusher(pusherDroite)) {

			puckRebondiSurPusher(pusherDroite);

		}
	}

	private void puckRebondiSurPusher(Pusher2d pusher) {

		if (getTopLeftX() < pusher.getTopLeftX()) {

			setTopLeftX(pusher.getTopLeftX() - getWidth() - 1);

		} else {

			setTopLeftX(pusher.getTopLeftX() + pusher.getWidth() + 1);

		}

		setSpeedX(-getSpeedX());

		jouerSonPuck();
	}

	private void balleRebondiSurMilieuMurGauche() {
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
		jouerSonBut();
	}

	private boolean balleFrappeMilieuMurDroit() {
		int middleRightX = (int) (getWorld2d().getWidth() - getWidth() / 2); // calcul les coordonnees X du milieu du mur droit
		int middleRightY = (int) (getWorld2d().getHeight() / 2); // calcul les coordonnees Y du milieu du mur droit

		return collidesWith(middleRightX, middleRightY, 1, 1);
	}

	private boolean balleFrappeMilieuMurGauche() {
		int middleLeftX = (int) (getWidth() / 2); // calcul les coordonnees X du milieu du mur gauche
		int middleLeftY = (int) (getWorld2d().getHeight() / 2); // calcul les coordonnees Y du milieu du mur gauche

		return collidesWith(middleLeftX, middleLeftY, 1, 1);
	}

	private void balleRebondiSurMilieuMurDroit() {
		setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
		jouerSonBut();

	}

	private boolean balleFrappeMurDroit() {
		return collidesWith(getWorld2d().getWidth() - 1, 0, 1, getWorld2d().getHeight());
	}

	private void balleRebondiSurMurDroit() {
		setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
		jouerSonPuck();
	}

	private boolean balleFrappeMurGauche() {
		return collidesWith(0, 0, 1, getWorld2d().getHeight());
	}

	private void balleRebondiSurMurGauche() {
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
		jouerSonPuck();
	}

	private boolean balleFrappePlafond() {
		return collidesWith(0, 0, getWorld2d().getWidth(), 1);
	}

	private void balleRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
		jouerSonPuck();

	}

	private boolean balleFrappePlancher() {
		return collidesWith(0, getWorld2d().getHeight(), getWorld2d().getWidth(), 1);
	}

	private void balleRebondiSurPlancher() {
		setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
		jouerSonPuck();
	}

	private void choisirEtatInitial() {

		setTopLeftY(10);
		setSpeedY(100 + Ntro.random().nextInt(20));

		if (Ntro.random().nextBoolean()) {

			setTopLeftX(100);
			setSpeedX(100 + Ntro.random().nextInt(20));

		} else {

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

	public But2d getButGauche() {
		return butGauche;
	}

	public void setButGauche(But2d butGauche) {
		this.butGauche = butGauche;
	}

	public But2d getButDroite() {
		return butDroite;
	}

	public void setButDroite(But2d butDroite) {
		this.butDroite = butDroite;
	}
}
