package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import main.Game;
import manager.GameStateManager;
import manager.MouseManager;

public class MenuState extends GameState {
	
	private final int WIDTH = Game.WIDTH;
	private final int HEIGHT = Game.HEIGHT;
	private final int SCALE = Game.SCALE;
		
	private int mX, mY;
	
	MouseManager mm;
	
	Graphics2D g;
	
	private String[] options = {
			"Play",
			"Decks",
			"Quit"
	};

	public MenuState(GameStateManager gsm, MouseManager mm) {
		super(gsm);
		
		this.mm = mm;
	}

	public void init() {
		
	}

	public void tick() {
		System.out.println("X: " + mX + " Y: " + mY);
	}

	public void render(Graphics2D graphics) {
		g = graphics;
		
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
		
		// Select Highlight
		// PLAY
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192)) {
			g.setColor(Color.gray);
			g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192);
		}	
	}

	public void mouseClicked(MouseEvent e) {
		// update location
		mX = e.getX();
		mY = e.getY();
		
		// PLAY
		if (mm.withinBoundaries(mX, mY, (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * 2 / 5) - 96, 512, 192)) {
			gsm.setState(GameStateManager.STARTMATCH);
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
