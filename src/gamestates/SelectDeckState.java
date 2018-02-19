package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import data.DataStorage;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;

public class SelectDeckState extends GameState {
	
	private static int NUM_DECKS = 0;
	private static int MAX_DECKS = 8;
	private static Deck decks[];
	
	// Load and Save
	DataStorage storage;

	public SelectDeckState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
		
		decks = new Deck[MAX_DECKS];
		
		storage = new DataStorage();
	}
	
	public void init() {		
		Object obj = storage.loadObjects();
		
		while (obj != null && NUM_DECKS < MAX_DECKS) {
			if (obj instanceof Deck) {
				decks[NUM_DECKS] = (Deck) obj;
			
				NUM_DECKS++;
			}
			
			obj = storage.loadObjects();			
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
		g.drawString("Select Deck", (WIDTH * SCALE / 2) - 488 + (WIDTH * SCALE / 16), (HEIGHT * SCALE / 5) + 42);
		
		// reset font for decks
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		
		for (int i = 1; i <= MAX_DECKS; i++) {
			// Decks #1 - #4
			if (i <= 4) {
				// Highlight
				if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 6 * i) + 48, (HEIGHT * SCALE / 3), 256, 384)) {
					g.setColor(Color.blue);
					g.fillRect((WIDTH * SCALE / 6 * i) + 48, (HEIGHT * SCALE / 3), 256, 384);
				}
				
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 6 * i) + 48, (HEIGHT * SCALE / 3), 256, 384);
				if (decks[0] != null) {
					g.drawString("Complete", (WIDTH * SCALE / 6 * i) + 72, (HEIGHT * SCALE / 2) - 42);
				} else {
					g.drawString("Not Built", (WIDTH * SCALE / 6 * i) + 80, (HEIGHT * SCALE / 2) - 42);
				}
				
			// Decks #5 - #8
			} else {
				// Highlight
				if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 6 * (i - 4)) + 48, (HEIGHT * SCALE / 3 * 2), 256, 384)) {
					g.setColor(Color.orange);
					g.fillRect((WIDTH * SCALE / 6 * (i - 4)) + 48, (HEIGHT * SCALE / 3 * 2), 256, 384);
				}
				
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 6 * (i - 4)) + 48, (HEIGHT * SCALE / 3 * 2), 256, 384);
				if (decks[0] != null) {
					g.drawString("Complete", (WIDTH * SCALE / 6 * (i - 4)) + 72, (HEIGHT * SCALE / 5 * 4));
				} else {
					g.drawString("Not Built", (WIDTH * SCALE / 6 * (i - 4)) + 80, (HEIGHT * SCALE / 5 * 4));
				}
			}
		}
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
