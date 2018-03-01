package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import manager.GameStateManager;
import manager.MouseManager;

public class StartupState extends GameState {

	public StartupState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
	}

	public void init() {
		// Will load logo in this method
	}

	public void tick() {
		// Will fade in logo in this method
		gsm.setState(GameStateManager.MENU);
	}

	public void render(Graphics2D g) {
		// Will display logo in this method
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
		mm.mouseSet(e.getButton(), true);
	}

	public void mouseReleased(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
		mm.mouseSet(e.getButton(), false);
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
