package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import manager.GameStateManager;
import manager.MouseManager;

public class MenuState extends GameState {
					
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

		for (int i = 2; i <= 4; i++) {
			// Highlight	
			if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192)) {
				g.setColor(Color.orange);
				g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
			}
			
			// Label
			g.setColor(Color.white);
			switch (i) {
				case 2: 
					g.drawString(options[0], (WIDTH * SCALE / 2) - 266 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * i / 5) + 42);
					g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
					break;
				case 3:
					g.drawString(options[1], (WIDTH * SCALE / 2) - 318 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * i / 5) + 42);
					g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
					break;
				case 4:
					g.drawString(options[2], (WIDTH * SCALE / 2) - 270 + (WIDTH * SCALE / 16), (HEIGHT * SCALE * i / 5) + 42);
					g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
					break;
			}
		}
		
	}

	// Mouse Events	
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
		
		for (int i = 2; i <= 4; i++) {
			if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192)) {
				switch(i) {
					case 2: 
						// (Press Play) Swap Deck Select State
						gsm.setState(GameStateManager.SELECTDECK);
						break;
					case 3: 
						// (Press Deck) Swap Deck Build State
						gsm.setState(GameStateManager.BUILDDECK);
						break;
					case 4:
						// (Press Quit) Exit Game 
						System.exit(0);
						break;
				}
			}
		}
		
	}

	// mouse enters component
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

	// mouse moved onto component but not clicked
	public void mouseMoved(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
				
	}

}
