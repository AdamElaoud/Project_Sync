package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import data.DataStorage;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;
import manager.VisualManager;

public class SelectDeckState extends GameState {
	
	private int NUM_DECKS = 0;
	private final int MAX_DECKS = 4;
	private int iconHeight = (HEIGHT * SCALE / 3) + 224;

	private static Deck decks[];
	
	public SelectDeckState(GameStateManager gsm, MouseManager mm, DataStorage storage, VisualManager vm) {
		super(gsm, mm, storage, vm);
		
		decks = new Deck[MAX_DECKS];
	}
	
	public void init() {
		String line;
		
		try {
			if (storage.setupLoad()) {
				line = storage.load();
				
				if (line != null && line.equals("DECK START")) {
					while (line != null && NUM_DECKS < MAX_DECKS) {
						decks[NUM_DECKS] = storage.buildDeck();
						System.out.println("Loaded deck: " + decks[NUM_DECKS].getName() + ", ID: " + decks[NUM_DECKS].getId());
						System.out.println("Elements: " + decks[NUM_DECKS].getElement(0) + " " + decks[NUM_DECKS].getElement(1) + " " + decks[NUM_DECKS].getElement(2));
						
						NUM_DECKS++;
						line = storage.load();
					}
				}
	
				storage.loadClose();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		System.out.println("Num Decks: " + NUM_DECKS);
		System.out.println("Decks: " + decks[0] + " " + decks[1] + " " + decks[2] + " " + decks[3]);

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
		
		// BACK
		g.setFont(new Font("Arial", Font.PLAIN, 72));
		if (mm.within(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			g.setColor(Color.cyan);
			g.fillRect(48, 48, 256, 128);
		}
		g.setColor(Color.white);
		g.drawString("Back", 96, 136);
		g.drawRect(48, 48, 256, 128);
		
		// reset font for decks
		g.setFont(new Font("Arial", Font.PLAIN, 48));
		
		switch(NUM_DECKS) {
			case 0: 
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH)) {
					g.setColor(Color.cyan);
					g.fillRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				}
			
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, "No Decks", (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.getDeckBox());
			
				break;
			case 1:
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH)) {
					g.setColor(Color.cyan);
					g.fillRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				}
			
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[0].getName(), (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.getDeckBox());
			
				break;
			case 2:	
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - vm.dW - (vm.dist / 2), iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) - vm.dW - (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - vm.dW - (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[0].getName(), (WIDTH * SCALE / 2) - vm.dW - (vm.dist / 2), iconHeight, vm.getDeckBox());
				
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				}
				
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[1].getName(), (WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.getDeckBox());
								
				break;
			case 3:
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (vm.dW / 2) - vm.dist - vm.dW, iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) - (vm.dW / 2) - vm.dist - vm.dW, iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (vm.dW / 2) - vm.dist - vm.dW, iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[0].getName(), (WIDTH * SCALE / 2) - (vm.dW / 2) - vm.dist - vm.dW, iconHeight, vm.getDeckBox());
					
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				}	
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[1].getName(), (WIDTH * SCALE / 2) - (vm.dW / 2), iconHeight, vm.getDeckBox());
					
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) + (vm.dW / 2) + vm.dist, iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) + (vm.dW / 2) + vm.dist, iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) + (vm.dW / 2) + vm.dist, iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[2].getName(), (WIDTH * SCALE / 2) + (vm.dW / 2) + vm.dist, iconHeight, vm.getDeckBox());
				
				break;
			case 4:
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (3 * vm.dist / 2) - (vm.dW * 2), iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) - (vm.dist / 2) - (vm.dW * 2) - vm.dist, iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (3 * vm.dist / 2) - (vm.dW * 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[0].getName(), (WIDTH * SCALE / 2) - (3 * vm.dist / 2) - (vm.dW * 2), iconHeight, vm.getDeckBox());
					
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) - (vm.dist / 2) - vm.dW, iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) - (vm.dist / 2) - vm.dW, iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) - (vm.dist / 2) - vm.dW, iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[1].getName(), (WIDTH * SCALE / 2) - (vm.dist / 2) - vm.dW, iconHeight, vm.getDeckBox());
					
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.dW, vm.dH);
				vm.centerText(g, decks[2].getName(), (WIDTH * SCALE / 2) + (vm.dist / 2), iconHeight, vm.getDeckBox());
				
				// Highlight
				if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE / 2) + (3 * vm.dist / 2) + vm.dW, iconHeight, vm.dW, vm.dH)) {
					// Color set
					g.setColor(Color.cyan);							
					g.fillRect((WIDTH * SCALE / 2) + (3 * vm.dist / 2) + vm.dW, iconHeight, vm.dW, vm.dH);
				}
					
				// Label
				g.setColor(Color.white);
				g.drawRect((WIDTH * SCALE / 2) + (3 * vm.dist / 2) + vm.dW, iconHeight, vm.dW, vm.dH);
				
				if (NUM_DECKS == 4)
					vm.centerText(g, decks[3].getName(), (WIDTH * SCALE / 2) + (3 * vm.dist / 2) + vm.dW, iconHeight, vm.getDeckBox());
				else
					vm.centerText(g, decks[3].getName(), (WIDTH * SCALE / 2) + (3 * vm.dist / 2) + vm.dW, iconHeight, vm.getDeckBox());
				
				break;
		}
	}

	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
		
		// Back
		if (mm.within(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			gsm.setState(GameStateManager.MENU);
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
