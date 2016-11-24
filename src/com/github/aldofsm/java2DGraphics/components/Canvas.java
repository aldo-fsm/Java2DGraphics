package com.github.aldofsm.java2DGraphics.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.github.aldofsm.java2DGraphics.drawing.Drawable;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;

	private BufferedImage screen;
	private ArrayList<Drawable> elements;
	private double originX = 0;
	private double originY = 0;
	private double scaleX = 10;
	private double scaleY = 10;

	public Canvas(int width, int height) {
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		elements = new ArrayList<Drawable>();
		MouseHandler mh = new MouseHandler(this);
		addMouseListener(mh);
		addMouseMotionListener(mh);
		addMouseWheelListener(mh);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(screen, 0, 0, null);

	}

	public void addDrawable(Drawable element) {
		elements.add(element);
	}

	public void removeDrawable(int index) {
		elements.remove(index);
	}

	public Drawable getDrawable(int index) {
		return elements.get(index);
	}

	public void removeDrawable(Drawable element) {
		elements.remove(element);
	}

	public void updateScreen() {
		cleanScreen();
		if (elements.size() > 0) {
			for (Drawable drawable : elements) {
				drawable.draw(this);
			}
		}
		repaint();
	}

	public void cleanScreen() {
		for (int i = 0; i < screen.getWidth(); i++) {
			for (int j = 0; j < screen.getHeight(); j++) {
				screen.setRGB(i, j, 0);
			}
		}
	}

	public void drawLine(double x1, double y1, double x2, double y2, Color color, Stroke stroke) {
		Graphics2D g2 = (Graphics2D) getImage().getGraphics();
		int[] point1 = convertToScreenCoordinates(x1, y1);
		int[] point2 = convertToScreenCoordinates(x2, y2);
		if (stroke != null)
			g2.setStroke(stroke);
		g2.setColor(color);
		g2.drawLine(point1[0], point1[1], point2[0], point2[1]);
	}

	public void drawPoint(double x, double y, Color color, int size) {

		int[] position = convertToScreenCoordinates(x, y);

		if (position[0] > 0 && position[1] > 0 && position[0] < getScreenWidth() && position[1] < getScreenHeight()) {
			Drawable.putPointScreen(position[0], position[1], size, color, getImage());
		}
	}

	private int[] convertToScreenCoordinates(double x, double y) {
		int pixelsX = (int) (x * getScaleX() - (getOriginX() * getScaleX() - getScreenWidth() / 2));
		int pixelsY = (int) (-y * getScaleY() - (-getOriginY() * getScaleY() - getScreenHeight() / 2));
		return new int[] { pixelsX, pixelsY };
	}

	public double getOriginX() {
		return originX;
	}

	public void setOriginX(double originX) {
		this.originX = originX;
	}

	public double getOriginY() {
		return originY;
	}

	public void setOriginY(double originY) {
		this.originY = originY;
	}

	public double getScaleX() {
		return scaleX;
	}

	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

	public int getScreenWidth() {
		return screen.getWidth();
	}

	public int getScreenHeight() {
		return screen.getHeight();
	}

	public BufferedImage getImage() {
		return screen;
	}

}
