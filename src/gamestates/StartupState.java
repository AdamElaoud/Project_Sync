package gamestates;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import data.DataStorage;
import data.EOF;
import entities.Deck;
import manager.GameStateManager;
import manager.MouseManager;
import manager.VisualManager;

public class StartupState extends GameState {

	public StartupState(GameStateManager gsm, MouseManager mm, DataStorage storage, VisualManager vm) {
		super(gsm, mm, storage, vm);
	}

	public void init() {
		// Will load logo in this method

		String line;
		Deck temp;
		int idCount = 0;
		
		try {
			if (storage.setupLoad()) {
				line = storage.load();
				
				if (line != null && line.equals("DECK START")) {
					while (line != null) {
						temp = storage.buildDeck();
						
						if (temp.getId() > idCount)
							idCount = temp.getId();
						
						line = storage.load();
					}
				}
	
				storage.loadClose();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Deck.setIdCount(idCount);
		System.out.println("Id Count Set To: " + idCount);
	}

	public void tick() {
		// Will fade in logo in this method
		gsm.setState(GameStateManager.MENU);
	}

	public void render(Graphics2D g) {
		// Will display logo in this method
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
