package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import data.DataStorage;
import manager.GameStateManager;
import manager.MouseManager;
import manager.VisualManager;

public class MenuState extends GameState {
					
	private String[] options = {
			"Play",
			"Decks",
			"Quit"
	};

	public MenuState(GameStateManager gsm, MouseManager mm, DataStorage storage, VisualManager vm) {
		super(gsm, mm, storage, vm);
	}

	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
		// set screen background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		// setting font
		g.setColor(Color.black);
		g.setFont(new Font("Courier", Font.PLAIN, 140));
		
		// TITLE
		vm.centerText(g, "MENU", 0, 0, new Rectangle(WIDTH * SCALE, (HEIGHT * SCALE / 5) + 150));

		for (int i = 2; i <= 4; i++) {
			// Highlight	
			if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192)) {
				g.setColor(new Color(175, 242, 255, 255));
				g.fillRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
			}
			
			// Label
			g.setColor(Color.black);
			switch (i) {
				case 2: 
					vm.centerText(g, options[0], (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, new Rectangle(512, 192));
					g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
					break;
				case 3:
					vm.centerText(g, options[1], (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, new Rectangle(512, 192));
					g.drawRect((WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192);
					break;
				case 4:
					vm.centerText(g, options[2], (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, new Rectangle(512, 192));
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
			if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - 256, (HEIGHT * SCALE * i / 5) - 96, 512, 192)) {
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
