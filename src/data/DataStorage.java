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
	
	public boolean overwriteDeck(Deck overwrite) {
		boolean overwritten = false;
		Object obj = loadObjects();
		Deck readIn;
		String overwriteName = overwrite.getName();
		String readInName;
		
		System.out.println("Overwrite deck name: " + overwriteName);
		
		// load all current decks
		try {
			
			System.out.println("Overwrite: " + obj);
			while (obj != null) {
				readIn = (Deck) obj;
				readInName = readIn.getName();
				
				System.out.println("Read in deck name: " + readInName);
				
				if (compare(overwriteName, readInName)) {
					System.out.println("Overwrite deck found!");
					deckSave.add(overwrite);
					overwritten = true;

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
		
		if (!overwritten)
			System.out.println("Did not find overwrite deck!");
		
		return overwritten;
	}
	
	private static boolean compare(String str1, String str2) {
		return (str1 == null) ? str2 == null : str1.equals(str2);
	}
}
