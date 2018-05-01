package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import data.DataStorage;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;
import manager.VisualManager;

public class FillDeckState extends GameState {
	
	private static final int MAX_CARDS = 40;
	
	// Elements
	private static final int PRIMARY = 0;
	private static final int SECONDARY = 1;
	private static final int TERTIARY = 2;
	
	// Deck
	private Deck deck;

	public FillDeckState(GameStateManager gsm, MouseManager mm, DataStorage storage, VisualManager vm) {
		super(gsm, mm, storage, vm);
	}
	
	public void init() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
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
	
	// Mouse Events
	public void mouseClicked(MouseEvent e) {
		// update location
		mm.setMX(e.getX());
		mm.setMY(e.getY());
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
