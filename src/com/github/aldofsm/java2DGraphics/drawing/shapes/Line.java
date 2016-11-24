package com.github.aldofsm.java2DGraphics.drawing.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import com.github.aldofsm.java2DGraphics.components.Canvas;
import com.github.aldofsm.java2DGraphics.drawing.Drawable;

public class Line implements Drawable {
	private double[] point1 = new double[2];
	private double[] point2 = new double[2];
	private Stroke stroke;
	private Color color;

	public Line(DrawablePoint point1, DrawablePoint point2) {
		setColor(point1.getColor());
		setPoint1(point1.getX(), point1.getY());
		setPoint2(point2.getX(), point2.getY());
		setThickness(point1.getDrawingSize());
	}

	public Line(double x1, double y1, double x2, double y2, Color color) {
		setColor(color);
		setPoint1(x1, y1);
		setPoint2(x2, y2);
		setThickness(1);
	}

	public Line(double x1, double y1, double x2, double y2, Color color, int thickness) {
		setColor(color);
		setPoint1(x1, y1);
		setPoint2(x2, y2);
		setThickness(thickness);
	}

	public double[] getPoint1() {
		return point1;
	}

	public void setPoint1(double x, double y) {
		this.point1 = new double[] { x, y };
	}

	public double[] getPoint2() {
		return point2;
	}

	public void setPoint2(double x, double y) {
		this.point2 = new double[] { x, y };
	}

	public void setThickness(float thickness) {
		this.stroke = new BasicStroke(thickness);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawLine(point1[0], point1[1], point2[0], point2[1], color, stroke);
	}

}
