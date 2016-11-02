package com.github.aldofsm.java2DGraphics.drawing.shapes;

import java.awt.Color;

import com.github.aldofsm.java2DGraphics.components.Canvas;
import com.github.aldofsm.java2DGraphics.drawing.Drawable;

public class DrawablePoint implements Drawable {

	private double[] position = new double[2];
	private int drawingSize;
	private Color color;

	public DrawablePoint(double x, double y, Color color) {
		setColor(color);
		setPosition(x, y);
		setDrawingSize(1);
	}

	public DrawablePoint(double x, double y, Color color, int drawingSize) {
		setColor(color);
		setPosition(x, y);
		setDrawingSize(drawingSize);
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
		if (drawingSize > 0) {
			this.drawingSize = drawingSize;
		} else {
			this.drawingSize = 1;
		}
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
