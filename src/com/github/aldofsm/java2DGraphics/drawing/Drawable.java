package com.github.aldofsm.java2DGraphics.drawing;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.github.aldofsm.java2DGraphics.components.Canvas;

public interface Drawable {

	public static int getIntARGB(Color color) {
		return color.getBlue() + color.getGreen() * 256 + color.getRed() * 65536 + color.getAlpha() * 16777216;
	}

	public static void putPointScreen(int x, int y, int pointSize, Color color, BufferedImage img) {
		pointSize--;
		for (int i = -pointSize; i <= pointSize; i++) {
			for (int j = -pointSize; j <= pointSize; j++) {
				try {
					img.setRGB(x + i, y + j, getIntARGB(color));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}

	public void draw(Canvas canvas);

}
