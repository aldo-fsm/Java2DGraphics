package drawing;

import java.awt.Color;
import java.awt.image.BufferedImage;

import components.Canvas;

public interface Drawable {

	public static int getIntRGB(Color color) {
		return color.getBlue() + color.getGreen() * 256 + color.getRed() * 65536;
	}

	public static void putPointScreen(int x, int y, int pointSize, Color color, BufferedImage img) {
		for (int i = -pointSize; i <= pointSize; i++) {
			for (int j = -pointSize; j <= pointSize; j++) {
				try {
					img.setRGB(x + i, y + j, getIntRGB(color));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}

	public void draw(Canvas canvas);

}
