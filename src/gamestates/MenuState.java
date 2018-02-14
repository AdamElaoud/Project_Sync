package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import manager.GameStateManager;
import manager.MouseManager;

public class MenuState extends GameState {
	
	private final int WIDTH = Game.WIDTH;
	private final int HEIGHT = Game.HEIGHT;
	private final int SCALE = Game.SCALE;
	
	MouseManager mm;
	
	private String[] options = {
			"Play",
			"Deck",
			"Quit"
	};

	public MenuState(GameStateManager gsm, MouseManager mm) {
		super(gsm);
		
		this.mm = mm;
	}

	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 140));
		
		// MENU
		g.drawString("MENU", (WIDTH * SCALE / 2) - 336 + (WIDTH * SCALE / 16), (HEIGHT * SCALE / 5) + 42);

		// PLAY
		g.drawString(options[0], (WIDTH * SCALE / 2) - 266 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 2 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
		
		
		// Deck
		g.drawString(options[1], (WIDTH * SCALE / 2) - 290 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 3 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 3 / 5) - 96, 512, 192);

		// Quit
		g.drawString(options[2], (WIDTH * SCALE / 2) - 270 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 4 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 4 / 5) - 96, 512, 192);
		
		// Select Highlight
		// PLAY
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192)) {
			g.setColor(Color.gray);
			g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
		}
		
	}

	public void handleInput() {
		
	}

	// Mouse Events
	public void mouseDragged(MouseEvent arg0) {
		
	}

	// mouse moved onto component but not clicked
	public void mouseMoved(MouseEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	// mouse enters component
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
