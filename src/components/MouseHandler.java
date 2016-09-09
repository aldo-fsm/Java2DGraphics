package components;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler implements MouseMotionListener, MouseListener, MouseWheelListener {

	private Canvas canvas;

	private int currentMouseButton;
	private Point currentMouseClick;

	public MouseHandler(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (currentMouseButton == MouseEvent.BUTTON3) {

			java.awt.Point point = e.getPoint();

			int dx = currentMouseClick.x - point.x;
			int dy = currentMouseClick.y - point.y;

			canvas.setOriginX(canvas.getOriginX() + dx / canvas.getScaleX());
			canvas.setOriginY(canvas.getOriginY() - dy / canvas.getScaleY());

			currentMouseClick = e.getPoint();
			canvas.updateScreen();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentMouseButton = e.getButton();
		currentMouseClick = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentMouseButton = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double scaleX = canvas.getScaleX();
		double scaleY = canvas.getScaleX();

		canvas.setScaleX(scaleX - e.getWheelRotation() * scaleX / 10);
		canvas.setScaleY(scaleY - e.getWheelRotation() * scaleY / 10);

		canvas.updateScreen();
	}

}
