package com.github.aldofsm.java2DGraphics.tests;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import com.github.aldofsm.java2DGraphics.components.Canvas;
import com.github.aldofsm.java2DGraphics.drawing.Axis;
import com.github.aldofsm.java2DGraphics.drawing.shapes.DrawablePoint;
import com.github.aldofsm.java2DGraphics.drawing.shapes.Line;

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame("test1");
		j.setVisible(true);
		j.setSize(800, 700);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas c = new Canvas(j.getWidth(), j.getHeight());

		j.add(c);
		Random rand = new Random();
		for (double x = -15; x < 15; x += 0.1) {
			DrawablePoint p1 = new DrawablePoint(0, 0, Color.BLUE, 2);
			DrawablePoint p2 = new DrawablePoint(0, 0, Color.BLUE);
			p1.setPosition(x, Math.sin(x));
			p2.setPosition(x + 0.1, Math.sin(x + 0.1));
			c.addDrawable(new Line(p1, p2));
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

		DrawablePoint p1 = new DrawablePoint(0, 0, Color.GREEN.darker(), 2);
		DrawablePoint p2 = null;
		for (double t = -15; t < 15; t += 0.05) {
			double x = Math.sin(t) * 20 + 5 + rand.nextDouble();
			double y = Math.cos(t) * 10 + 2 + rand.nextDouble();
			p1.setPosition(x, y);
			if (p2 == null)
				p2 = new DrawablePoint(p1.getX(), p1.getY(), p1.getColor());
			c.addDrawable(new Line(p1, p2));
			p2.setPosition(x, y);
		}

		c.addDrawable(new Axis(0, 0, 1));
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
