package pong.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Palette2d extends ObjetPong2d {

	private static final double VITESSE_PALETTE = 200;

	public Palette2d() {
		super();
	}

	public Palette2d(double topLeftX) {
		super();

		setTopLeftX(topLeftX);
	}

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(100);

		setTopLeftY(getWorld2d().getHeight() / 2 - getHeight() / 2);
	}

	protected boolean onMouseEvent(MouseEvent evtFx, double x, double y) {
		return false;
	}

	public void monter() {
		setSpeedY(-VITESSE_PALETTE);
	}

	public void descendre() {
		setSpeedY(+VITESSE_PALETTE);
	}

	public void arreter() {
		setSpeedY(0);
	}

	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
		// TODO Auto-generated method stub
		canvas.drawOnWorld(gc -> {
			gc.save();

			gc.setFill(Color.BLACK);

			gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
			// gc.drawImage(image, getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

			gc.restore();

		});
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}
}