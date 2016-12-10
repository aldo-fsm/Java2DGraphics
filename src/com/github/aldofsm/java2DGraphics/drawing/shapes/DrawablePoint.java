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
		canvas.drawPoint(getX(), getY(), color, drawingSize);
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
