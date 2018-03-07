package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import data.DataStorage;
import entities.Deck;
import entities.Element;
import manager.GameStateManager;
import manager.MouseManager;

public class CreateDeckState extends GameState {
	
	private static final int MAX_ELEMENTS = 8;
	
	// Deck
	private Deck deck;
	private FillDeckState fill;
		
	// Elements
	private static final int PRIMARY = 0;
	private static final int SECONDARY = 1;
	private static final int TERTIARY = 2;
	private Element[] record;
	private Element[] prevRecord;
	
	// Element List
	private static Element[] elements = {
			Element.Time, Element.Fire, Element.Life, Element.Thunder, 
			Element.Earth, Element.Shadow, Element.Water, Element.Air};
	int count;

	public CreateDeckState(GameStateManager gsm, MouseManager mm, DataStorage storage) {
		super(gsm, mm, storage);
	}

	public void init() {
		storage.initDeckSave();
		record = new Element[3];
		prevRecord = new Element[3];
	}
	
	public void setDeck(Deck deck) {
		if (deck != null) {
			this.deck = deck;
			System.out.println(deck.getElement(PRIMARY) + " " + deck.getElement(SECONDARY) + " " + deck.getElement(TERTIARY));
		} else  {
			this.deck = new Deck();
			this.deck.setName("First");
		}
		
	}

	public void tick() {
		for (int i = 0; i < 3; i++) {
			if (prevRecord[i] != record[i]) {
				System.out.println("Element Changed!");
				// if element is changed, initiate save
				if (!storage.overwriteDeck(deck))
					storage.saveObject(deck);
			}
		}
		
		// update records of elements after check (if before, will not register because tick is so fast)
		for (int i = 0; i < 3; i++) {
			prevRecord[i] = record[i];
		}
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
			if (deck.getElement(PRIMARY) != null && deck.getElement(SECONDARY) != null && deck.getElement(TERTIARY) != null ) {
				g.setColor(Color.cyan);
			} else {
				g.setColor(Color.lightGray);
			}
			
			g.fillRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		}
		g.setColor(Color.white);
		g.drawString("Next", (WIDTH * SCALE) - 256, (HEIGHT * SCALE) - 90);
		g.drawRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		
		// Primary
		g.drawString("Primary:", 256, (HEIGHT * SCALE * 2 / 5));
		// Secondary
		g.drawString("Secondary:", 256, (HEIGHT * SCALE * 3 / 5));
		// Tertiary
		g.drawString("Tertiary:", 256, (HEIGHT * SCALE * 4 / 5));
		// Name
		g.drawString("Name: " + deck.getName(), (WIDTH * SCALE) - 512, 128);
		
		// Permanent Selection
		g.setColor(Color.lightGray);
		count = 0;
		for (Element ele: elements) {
			if (deck.getElement(PRIMARY) == ele) {
				g.fillRect(256 + (count * 196) - 10, (HEIGHT * SCALE * 2 / 5) + 40, 148, 80);
			}
			
			if (deck.getElement(SECONDARY) == ele) {
				g.fillRect(256 + (count * 196) - 10, (HEIGHT * SCALE * 3 / 5) + 40, 148, 80);
			}
			
			if (deck.getElement(TERTIARY) == ele) {
				g.fillRect(256 + (count * 196) - 10, (HEIGHT * SCALE * 4 / 5) + 40, 148, 80);
			}
			
			count++;
		}
		
		// Elements
		for (int i = 2; i <= 4; i++) {
			for (int j = 0; j < MAX_ELEMENTS; j++) {
				// Highlight
				if (mm.withinBoundaries(mm.getMX(), mm.getmY(), 256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64)) {
					g.setColor(Color.lightGray);
					g.fillRect(256 + (j * 196) - 10, (HEIGHT * SCALE * i / 5) + 40, 148, 80);
				}		
				
				// Color Scheme
				switch (j) {
					// Time
					case 0:
						g.setColor(Color.orange);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Fire
					case 1:
						g.setColor(Color.red);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Life
					case 2:
						g.setColor(Color.green);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Thunder
					case 3:
						g.setColor(Color.yellow);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Earth
					case 4:
						g.setColor(new Color(102, 51, 0));
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Shadow
					case 5:
						g.setColor(Color.magenta);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Water
					case 6:
						g.setColor(Color.blue);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;
					// Air
					case 7:
						g.setColor(Color.cyan);
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;	
				}
								
				g.setColor(Color.white);
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
			storage.closeSave();
			gsm.setState(GameStateManager.BUILDDECK);
		}
		
		// Next
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), (WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128)
				&& deck.getElement(PRIMARY) != null && deck.getElement(SECONDARY) != null && deck.getElement(TERTIARY) != null) {
			storage.closeSave();
			gsm.setState(GameStateManager.FILLDECK);
			fill = (FillDeckState) gsm.getCurrentState();
			fill.setDeck(deck);
		}
		
		// Select Elements
		for (int i = 2; i <= 4; i++) {
			for (int j = 0; j < MAX_ELEMENTS; j++) {
				if (mm.withinBoundaries(mm.getMX(), mm.getmY(), 256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64)) {
					switch (j) {
					case 0: 
						deck.setElement(i - 2, Element.Time);
						record[i - 2] = Element.Time;
						break;
					case 1: 
						deck.setElement(i - 2, Element.Fire);
						record[i - 2] = Element.Fire;
						break;
					case 2: 
						deck.setElement(i - 2, Element.Life);
						record[i - 2] = Element.Life;
						break;
					case 3: 
						deck.setElement(i - 2, Element.Thunder);
						record[i - 2] = Element.Thunder;
						break;
					case 4: 
						deck.setElement(i - 2, Element.Earth);
						record[i - 2] = Element.Earth;
						break;
					case 5: 
						deck.setElement(i - 2, Element.Shadow);
						record[i - 2] = Element.Shadow;
						break;
					case 6: 
						deck.setElement(i - 2, Element.Water);
						record[i - 2] = Element.Water;
						break;
					case 7: 
						deck.setElement(i - 2, Element.Air);
						record[i - 2] = Element.Air;
						break;
					}
					
					// Print out Element Selection
					if (deck != null) {
//						System.out.println(record[0] + " " + record[1] + " " + record[2]);
					}
					
				}
			}
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
