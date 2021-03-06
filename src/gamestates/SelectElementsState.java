package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.IOException;

import data.DataStorage;
import entities.Deck;
import entities.Element;
import manager.*;

public class SelectElementsState extends GameState {
	
	private static final int MAX_ELEMENTS = 8;
	
	// Deck
	private Deck deck;
	private FillDeckState fill;
		
	// Elements
	private static final int PRIMARY = 0;
	private static final int SECONDARY = 1;
	private static final int TERTIARY = 2;
	private Element[] record = new Element[3];
	private Element[] prevRecord = new Element[3];
	
	// Element List
	private static Element[] elements = {
			Element.Time, Element.Fire, Element.Life, Element.Thunder, 
			Element.Earth, Element.Shadow, Element.Water, Element.Air};
	int count;

	public SelectElementsState(GameStateManager gsm, MouseManager mm, DataStorage storage, VisualManager vm) {
		super(gsm, mm, storage, vm);
	}

	public void init() {

	}
	
	public void setDeck(Deck deck) {
		if (deck != null) {
			this.deck = deck;
			System.out.println("Elements: " + deck.getElement(PRIMARY) + " " + deck.getElement(SECONDARY) + " " + deck.getElement(TERTIARY));
		} else  {
			this.deck = new Deck();
			this.deck.setName("Default");
		}
		
		System.out.println("Creating Deck: " + deck.getName() + ", ID: " + deck.getId());

	}

	public void tick() {
		// update records of elements 
		for (int i = 0; i < 3; i++) {
			prevRecord[i] = record[i];
		}
	}

	public void render(Graphics2D g) {
		// reset background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		// setting font
		g.setColor(Color.black);
		g.setFont(new Font("Courier", Font.PLAIN, 140));
		
		// TITLE
		vm.centerText(g, "ELEMENT SELECT", 0, 0, new Rectangle(WIDTH * SCALE, (HEIGHT * SCALE / 5) + 250));
		
		// BACK
		g.setFont(new Font("Courier", Font.PLAIN, 72));
		if (mm.within(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			g.setColor(new Color(175, 242, 255, 255));
			g.fillRect(48, 48, 256, 128);
		}
		g.setColor(Color.black);
		vm.centerText(g, "Back", 48, 48, new Rectangle(256, 128));
		g.drawRect(48, 48, 256, 128);
		
		// NEXT
		if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128)) {
			if (deck.getElement(PRIMARY) != null && deck.getElement(SECONDARY) != null && deck.getElement(TERTIARY) != null ) {
				g.setColor(new Color(175, 242, 255, 255));
			} else {
				g.setColor(Color.lightGray);
			}
			
			g.fillRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		}
		g.setColor(Color.black);
		vm.centerText(g, "Next", (WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, new Rectangle(256, 128));
		g.drawRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
		
		// Primary
		g.drawString("Primary:", 256, (HEIGHT * SCALE * 2 / 5));
		// Secondary
		g.drawString("Secondary:", 256, (HEIGHT * SCALE * 3 / 5));
		// Tertiary
		g.drawString("Tertiary:", 256, (HEIGHT * SCALE * 4 / 5));
		// Name
		vm.centerText(g, "Name: " + deck.getName(), 0, 0, new Rectangle(WIDTH * SCALE, (HEIGHT * SCALE / 5) + 550));
		
		// Permanent Selection
		g.setColor(new Color(204, 153, 0));
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
				if (mm.within(mm.getMX(), mm.getmY(), 256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64)) {
					g.setColor(new Color(204, 153, 0));
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
						g.setColor(new Color(175, 242, 255, 255));
						g.fillRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
						break;	
				}
								
				//g.setColor(Color.white);
				//g.drawRect(256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64);
			}
		}
		
		
		
	}
	
	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
				
		// Back
		if (mm.within(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			try {
				storage.saveDeck(deck);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			gsm.setState(GameStateManager.BUILDDECK);
		}
		
		// Next
		if (mm.within(mm.getMX(), mm.getmY(), (WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128)
				&& deck.getElement(PRIMARY) != null && deck.getElement(SECONDARY) != null && deck.getElement(TERTIARY) != null) {
			
			try {
				storage.saveDeck(deck);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			gsm.setState(GameStateManager.FILLDECK);
			fill = (FillDeckState) gsm.getCurrentState();
			fill.setDeck(deck);
		}
		
		// Select Elements
		for (int i = 2; i <= 4; i++) {
			for (int j = 0; j < MAX_ELEMENTS; j++) {
				if (mm.within(mm.getMX(), mm.getmY(), 256 + (j * 196), (HEIGHT * SCALE * i / 5) + 48, 128, 64)) {
					switch (j) {
					case 0: 
						if (deck.getElement(i - 2) == Element.Time)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Time);
							record[i - 2] = Element.Time;
						}
						break;
					case 1: 
						if (deck.getElement(i - 2) == Element.Fire)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Fire);
							record[i - 2] = Element.Fire;
						}
						break;
					case 2:
						if (deck.getElement(i - 2) == Element.Life)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Life);
							record[i - 2] = Element.Life;
						}
						break;
					case 3: 
						if (deck.getElement(i - 2) == Element.Thunder)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Thunder);
							record[i - 2] = Element.Thunder;
						}
						break;
					case 4: 
						if (deck.getElement(i - 2) == Element.Earth)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Earth);
							record[i - 2] = Element.Earth;
						}
						break;
					case 5: 
						if (deck.getElement(i - 2) == Element.Shadow)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Shadow);
							record[i - 2] = Element.Shadow;
						}
						break;
					case 6: 
						if (deck.getElement(i - 2) == Element.Water)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Water);
							record[i - 2] = Element.Water;
						}
						break;
					case 7: 
						if (deck.getElement(i - 2) == Element.Air)
							deck.setElement(i - 2, null);
						else {
							deck.setElement(i - 2, Element.Air);
							record[i - 2] = Element.Air;
						}
						break;
					}
					
					// Print out Element Selection
					if (deck != null) {
						System.out.println("Elements Updated! " + record[0] + " " + record[1] + " " + record[2]);
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
