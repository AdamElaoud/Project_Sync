package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import entities.Deck;

public class DataStorage implements Serializable {

	private static final long serialVersionUID = 1752536480676738644L;
	
	// Saving
	private FileOutputStream saveFile;
	private ObjectOutputStream save;
	
	// Loading
	private FileInputStream loadFile;
	private ObjectInputStream load;
	
	// Overwrite
	private ArrayList<Deck> deckSave;

	public DataStorage() {
		deckSave = new ArrayList<Deck>();
		
	}
	
	public void initDeckSave() {
		try {
			// Saving
			saveFile = new FileOutputStream("src\\data\\deckSaveFile.sav");
			save = new ObjectOutputStream(saveFile);
			
			// Loading
			loadFile = new FileInputStream("src\\data\\deckSaveFile.sav");
			load = new ObjectInputStream(loadFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initGeneralSave() {
		try {
			// Saving
			saveFile = new FileOutputStream("src\\data\\saveFile.sav");
			save = new ObjectOutputStream(saveFile);
			
			// Loading
			loadFile = new FileInputStream("src\\data\\saveFile.sav");
			load = new ObjectInputStream(loadFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveObject(Object obj) {
		try {
			save.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object loadObjects() {
		try {
			return load.readObject();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void closeSave() {
		try {
			// close Output stream
			save.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeLoad() {
		try {
			// close Input stream
			load.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void overwriteDeck(Deck overwrite) {
		Object obj = loadObjects();
		Deck readIn;
		
		// load all current decks
		try {
			while (obj != null) {
				readIn = (Deck) obj;
				
				if (overwrite.getName().equals(readIn.getName())) {
					deckSave.add(overwrite);

				} else {
					deckSave.add(readIn);
				}
				
				obj = loadObjects();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Overwrite
		for (Deck deck : deckSave) {
			saveObject(deck);
		}
		
		// clear deckSave
		deckSave.clear();
	}
}
