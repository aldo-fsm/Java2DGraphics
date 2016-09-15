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

		for (int i = -1500; i < 1500; i++) {
			double x = (double) i / 100;
			double y = Math.sin(x);
			c.addDrawable(new DrawablePoint(x, y, Color.BLUE, 2));
		}

		for (int i = -1500; i < 1500; i++) {
			double x = (double) i / 100;
			double y = 0;
			for (int n = 0; n < 1; n++) {
				y += Math.pow(x, 2 * n + 1) * Math.pow(-1, n) / fatorial(2 * n + 1);
			}
			c.addDrawable(new DrawablePoint(x, y, Color.RED, 2));
		}
		for (int i = -1500; i < 1500; i++) {
			double x = (double) i / 100;
			double y = 0;
			for (int n = 0; n < 2; n++) {
				y += Math.pow(x, 2 * n + 1) * Math.pow(-1, n) / fatorial(2 * n + 1);
			}
			c.addDrawable(new DrawablePoint(x, y, Color.YELLOW, 2));
		}
		for (int i = -1500; i < 1500; i++) {
			double x = (double) i / 100;
			double y = 0;
			for (int n = 0; n < 3; n++) {
				y += Math.pow(x, 2 * n + 1) * Math.pow(-1, n) / fatorial(2 * n + 1);
			}
			c.addDrawable(new DrawablePoint(x, y, Color.GREEN, 2));
		}
		for (int i = -1500; i < 1500; i++) {
			double x = (double) i / 100;
			double y = 0;
			for (int n = 0; n < 7; n++) {
				y += Math.pow(x, 2 * n + 1) * Math.pow(-1, n) / fatorial(2 * n + 1);
			}
			c.addDrawable(new DrawablePoint(x, y, Color.CYAN, 2));
		}

		c.addDrawable(new Axis(0, 0, 2));

		c.updateScreen();

	}

	public static long fatorial(int n) {
		long result = 1;
		for (int i = n; i > 1; i--) {
			result *= i;
		}
		return result;
	}
}
