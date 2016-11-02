package com.github.aldofsm.java2DGraphics.drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.github.aldofsm.java2DGraphics.components.Canvas;

public class Axis implements Drawable {

	private double[] origin = new double[2];
	private Color color;
	private boolean gridVisible;
	private float thickness;

	public Axis(double x, double y) {
		setX(x);
		setY(y);
		setColor(Color.BLACK);
		setThickness(1);
	}

	public Axis(double x, double y, float thickness, Color color) {
		setX(x);
		setY(y);
		setThickness(thickness);
		setColor(color);
	}

	public Axis(double x, double y, float thickness) {
		setX(x);
		setY(y);
		setColor(Color.BLACK);
		setThickness(thickness);
	}

	@Override
	public void draw(Canvas canvas) {

		Graphics2D g2 = canvas.getImage().createGraphics();
		g2.setColor(getColor());

		if (gridVisible) {

		}

		if (thickness > 1) {
			g2.setStroke(new BasicStroke(thickness));
		}

		int pixelsX = (int) (canvas.getScreenWidth() / 2 - canvas.getScaleX() * (canvas.getOriginX() - getX()));
		int pixelsY = (int) (canvas.getScreenHeight() / 2 + canvas.getScaleY() * (canvas.getOriginY() - getY()));

		g2.drawLine(pixelsX, 0, pixelsX, canvas.getScreenHeight());
		g2.drawLine(0, pixelsY, canvas.getScreenWidth(), pixelsY);
	}

	public double getX() {
		return origin[0];
	}

	public void setX(double x) {
		origin[0] = x;
	}

	public double getY() {
		return origin[1];
	}

	public void setY(double y) {
		origin[1] = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setGridVisible(boolean visible) {
		this.gridVisible = visible;
	}

	public void setThickness(float thickness) {
		if (thickness > 0)
			this.thickness = thickness;
	}
}
