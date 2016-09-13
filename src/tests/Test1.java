package tests;

import java.awt.Color;

import javax.swing.JFrame;

import components.Canvas;
import drawing.Axis;
import drawing.shapes.DrawablePoint;

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame("test1");
		j.setVisible(true);
		j.setSize(800, 700);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas c = new Canvas(j.getWidth(), j.getHeight());

		j.add(c);

		c.addDrawable(new DrawablePoint(10, 20, Color.BLACK, 10));
		c.addDrawable(new DrawablePoint(20, 10, Color.BLUE, 10));
		c.addDrawable(new DrawablePoint(-30, 30, Color.RED, 10));
		c.addDrawable(new DrawablePoint(30, -30, Color.GREEN, 10));

		for (int i = 0; i < 3000; i++) {
			c.addDrawable(
					new DrawablePoint((double) i / 100, 10 * Math.sin((double) i / 150), new Color(0, 200, 0), 2));
		}
		for (int i = -1500; i < 1500; i++) {
			c.addDrawable(new DrawablePoint((double) i / 100, (double) i * i / 100000 - 5, new Color(200, 0, 0), 2));
		}
		for (int i = -1500; i < 1500; i++) {
			c.addDrawable(
					new DrawablePoint((double) i / 100, (double) i / 100 * Math.cos((double) i / 100), Color.BLUE, 2));
		}

		c.addDrawable(new Axis(0, 0, 2));

		c.updateScreen();

	}
}
