package drawing.shapes;

import java.awt.Color;

import components.Canvas;
import drawing.Drawable;

public class Point implements Drawable {

	private double[] position = new double[2];
	private int drawingSize = 1;
	private Color color;

	public Point(double x, double y, Color color) {
		setColor(color);
		setPosition(x, y);
	}

	@Override
	public void draw(Canvas canvas) {
		
		int pixelsX = (int) (getX() * canvas.getScaleX()
				- (canvas.getOriginX() * canvas.getScaleX() - canvas.getScreenWidth() / 2));

		int pixelsY = (int) (-getY() * canvas.getScaleY()
				- (-canvas.getOriginY() * canvas.getScaleY() - canvas.getScreenHeight() / 2));
		
		if (pixelsX > 0 && pixelsY > 0 && pixelsX < canvas.getScreenWidth() && pixelsY < canvas.getScreenHeight()) {
			Drawable.putPointScreen(pixelsX, pixelsY, getDrawingSize(), color, canvas.getImage());
		}
	}

	public int getDrawingSize() {
		return drawingSize;
	}

	public void setDrawingSize(int drawingSize) {
		this.drawingSize = drawingSize;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPosition(double x, double y) {
		position[0] = x;
		position[1] = y;
	}

	public double getX() {
		return position[0];
	}

	public double getY() {
		return position[1];
	}

}
