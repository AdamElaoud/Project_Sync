package gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import main.Game;
import manager.GameStateManager;
import manager.MouseManager;

public class StartMatchState extends GameState {

	public StartMatchState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
	}
	
	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		// reset background
		g.setColor(Color.white);
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
	}

	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}

}
