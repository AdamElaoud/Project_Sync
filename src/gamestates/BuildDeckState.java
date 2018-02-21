package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import manager.GameStateManager;
import manager.MouseManager;

public class BuildDeckState extends GameState {

	public BuildDeckState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
	}

	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
	}
	
	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mouseEntered(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mouseExited(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mousePressed(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mouseReleased(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mouseDragged(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}

	public void mouseMoved(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());

	}
}
