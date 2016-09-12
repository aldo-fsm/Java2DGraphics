package components;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

import drawing.Drawable;

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
