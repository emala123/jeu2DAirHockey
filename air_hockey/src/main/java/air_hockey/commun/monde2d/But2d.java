package air_hockey.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class But2d extends ObjetAirHockey2d {

	public But2d() {
		super();
	}

	public But2d(double topLeftX) {
		super();

		setTopLeftX(topLeftX);
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		// TODO Auto-generated method stub

		gc.save();


		double canvasWidth = 640; 
		double canvasHeight = 360; 

		double rectWidth = 25;
		double rectHeight = 50; 

		double leftRectX = 0; 
		double leftRectY = (canvasHeight - rectHeight) / 2; 
		double rightRectX = canvasWidth - rectWidth;
		double rightRectY = (canvasHeight - rectHeight) / 2; 

		gc.setFill(Color.BLACK);
		gc.setLineWidth(2);

		// droite
		gc.strokeRect(leftRectX, leftRectY, rectWidth, rectHeight);
		gc.fillRect(leftRectX, leftRectY, rectWidth, rectHeight);

		// gauche
		gc.strokeRect(rightRectX, rightRectY, rectWidth, rectHeight);
		gc.fillRect(rightRectX, rightRectY, rectWidth, rectHeight);


		gc.restore();
		
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		setWidth(40);
		setHeight(40);

		setTopLeftY(getWorld2d().getHeight() / 2 - getHeight() / 2);
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}

}
