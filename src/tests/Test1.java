package tests;

import javax.swing.JFrame;

import components.Canvas;

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame("test1");
		j.setVisible(true);
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas c = new Canvas(500, 500);
		
		j.add(c);
		j.paintAll(j.getGraphics());
		
	}
}
