package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import main.Game;
import manager.GameStateManager;
import manager.MouseManager;

public class MenuState extends GameState {
	
	private static final int WIDTH = Game.WIDTH;
	private static final int HEIGHT = Game.HEIGHT;
	private static final int SCALE = Game.SCALE;
		
	private static int mX, mY;
			
	private String[] options = {
			"Play",
			"Decks",
			"Quit"
	};

	public MenuState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
	}

	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
		// set screen background
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		// setting font
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 140));
		
		// MENU
		g.drawString("MENU", (WIDTH * SCALE / 2) - 336 + (WIDTH * SCALE / 16), (HEIGHT * SCALE / 5) + 42);

		// PLAY
		g.drawString(options[0], (WIDTH * SCALE / 2) - 266 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 2 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
		
		// Decks
		g.drawString(options[1], (WIDTH * SCALE / 2) - 318 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 3 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 3 / 5) - 96, 512, 192);

		// Quit
		g.drawString(options[2], (WIDTH * SCALE / 2) - 270 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 4 / 5) + 42);
		g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 4 / 5) - 96, 512, 192);
		
		// Select Highlight
		// Play
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192)) {
			g.setColor(Color.orange);
			g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
			g.setColor(Color.white);
			g.drawString(options[0], (WIDTH * SCALE / 2) - 266 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 2 / 5) + 42);
			g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
		}
		
		// Decks
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 3 / 5) - 96, 512, 192)) {
			g.setColor(Color.pink);
			g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 3 / 5) - 96, 512, 192);
			g.setColor(Color.white);
			g.drawString(options[1], (WIDTH * SCALE / 2) - 318 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 3 / 5) + 42);
			g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 3 / 5) - 96, 512, 192);
		}
		
		// Quit
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 4 / 5) - 96, 512, 192)) {
			g.setColor(Color.magenta);
			g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 4 / 5) - 96, 512, 192);
			g.setColor(Color.white);
			g.drawString(options[2], (WIDTH * SCALE / 2) - 270 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * 4 / 5) + 42);
			g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 4 / 5) - 96, 512, 192);
		}
		
	}

	// Mouse Events	
	public void mouseDragged(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

	// mouse moved onto component but not clicked
	public void mouseMoved(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

	public void mouseClicked(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
		
		// Swap Deck Select State
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192)) {
			gsm.setState(gsm.SELECTDECK);
		}
		
	}

	// mouse enters component
	public void mouseEntered(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
				
	}

}
