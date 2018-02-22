package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import data.DataStorage;
import entities.Card;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;

public class CreateDeckState extends GameState {
	
	private static final int MAX_ELEMENTS = 8;
	
	// Deck
	Deck deck;
	Card[] cards;
	
	// Load and Save
	DataStorage storage;

	public CreateDeckState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
		
		storage = new DataStorage();
	}

	public void init() {
		
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
		
		if (deck != null) {
			cards = deck.getCards();
		}
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		// reset background
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		// setting font
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 140));
		
		// MENU
		g.drawString("Deck Builder", (WIDTH * SCALE / 2) - 512 + (WIDTH * SCALE / 16), (HEIGHT * SCALE / 5) + 42);
		
		// BACK
		g.setFont(new Font("Arial", Font.PLAIN, 72));
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			g.setColor(Color.cyan);
			g.fillRect(48, 48, 256, 128);
		}
		g.setColor(Color.white);
		g.drawString("Back", 96, 136);
		g.drawRect(48, 48, 256, 128);
		
		// NEXT
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128)) {
			g.setColor(Color.cyan);
			g.fillRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		}
		g.setColor(Color.white);
		g.drawString("Next", (WIDTH * SCALE) - 256, (HEIGHT * SCALE) - 90);
		g.drawRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		
		// Primary
		g.drawString("Primary: ", 256, (HEIGHT * SCALE * 2 / 5));
		// Secondary
		g.drawString("Secondary: ", 256, (HEIGHT * SCALE * 3 / 5));
		// Tertiary
		g.drawString("Tertiary: ", 256, (HEIGHT * SCALE * 4 / 5));
		
		// Elements
		for (int i = 2; i <= 4; i++) {
			for (int j = 0; j < MAX_ELEMENTS; j++) {
				// Time
				// Fire
				// Life
				// Thunder
				// Earth
				// Shadow
				// Water
				// Air
				g.drawRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
			}
		}
		
	}
	
	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
		
		// Back
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			gsm.setState(GameStateManager.BUILDDECK);
		}
		
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
