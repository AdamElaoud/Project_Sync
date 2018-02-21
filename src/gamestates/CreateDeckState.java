package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import data.DataStorage;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;

public class CreateDeckState extends GameState {
	
	// Deck
	Deck deck;
	
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
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		
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
