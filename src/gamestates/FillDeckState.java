package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import data.DataStorage;
import entities.Card;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;

public class FillDeckState extends GameState {
	
	// Card list
	private ArrayList<Card> allCards;
	
	// Load and Save
	private DataStorage storage;
	
	// Deck setup
	private boolean full;
	private Deck deck;
	private Card[] cards;
	private CreateDeckState create;
	
	public FillDeckState(GameStateManager gsm, MouseManager mm) {
		super(gsm, mm);
	}

	public void init() {
		// Deck Setup
		allCards = new ArrayList<Card>();
		full = false;
		
		// Data Setup
		storage = new DataStorage();
		storage.initDeckSave();
	}
	
	public void setDeck(Deck deck) {
		if (deck != null) {
			this.deck = deck;
			cards = deck.getCards();
		} else  {
			this.deck = new Deck();
		}
		
	}

	public void tick() {
		if (!storage.overwriteDeck(deck))
			storage.saveObject(deck);
	}

	public void render(Graphics2D g) {
		// reset background
				g.setColor(Color.darkGray);
				g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
				
				// setting font
				g.setColor(Color.white);
				g.setFont(new Font("Arial", Font.PLAIN, 140));
								
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
					if (full) {
						g.setColor(Color.cyan);
					} else {
						g.setColor(Color.lightGray);
					}
					
					g.fillRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
				}
				g.setColor(Color.white);
				g.drawString("Next", (WIDTH * SCALE) - 256, (HEIGHT * SCALE) - 90);
				g.drawRect((WIDTH * SCALE) - 304, (HEIGHT * SCALE) - 176, 256, 128);
				
				// Name
				g.drawString("Name: " + deck.getName(), (WIDTH * SCALE) - 512, 128);
	}
	
	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
		
		// Back
		if (mm.withinBoundaries(mm.getMX(), mm.getmY(), 48, 48, 256, 128)) {
			gsm.setState(GameStateManager.CREATEDECK);
			create = (CreateDeckState) gsm.getCurrentState();
			create.setDeck(deck);
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
