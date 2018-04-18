package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import entities.Deck;
import entities.Element;

public class DataStorage implements Serializable {

	private static final long serialVersionUID = 1752536480676738644L;
	
	// Saving
	private FileOutputStream saveFile;
	private ObjectOutputStream save;
	private BufferedOutputStream bout;
	
	// Loading
	private FileInputStream loadFile;
	private ObjectInputStream load;
	private BufferedInputStream bin;
	
	FileWriter writer;
	FileReader reader;
	BufferedWriter buffWriter;
	BufferedReader buffReader;
	
	// Overwrite
	private ArrayList<Deck> deckSave;

	public DataStorage() {
		deckSave = new ArrayList<Deck>();
	}
	
	public void setupSave() throws IOException {
		// save
		writer = new FileWriter("src\\data\\deckSave.txt");
		buffWriter = new BufferedWriter(writer);
	}
	
	public void setupLoad() throws FileNotFoundException {
		// load
		reader = new FileReader("src\\data\\deckSave.txt");
		buffReader = new BufferedReader(reader);
	}
	
	public void save(String text) throws IOException {
		buffWriter.write(text);
	}
	
	public String load() throws IOException {
		return buffReader.readLine();
	}
	
	public void saveClose() throws IOException {
		save.close();
	}
	
	public void loadClose() throws IOException {
		load.close();
	}
	
	public Deck buildDeck() throws IOException {
		String line;
		Deck compiled = new Deck();
		
		line = load();
		while (!line.equals("DECK END")) {
			switch (line) {
				case "ID:\n":
					line = load();
					compiled.setId(Integer.parseInt(line));
					break;
				case "Name:\n":
					line = load();
					compiled.setName(line);
					break;
				case "Primary:\n":
					line = load();
					compiled.setElement(0, parseElement(line));
					break;
				case "Secondary:\n":
					line = load();
					compiled.setElement(1, parseElement(line));
					break;
				case "Tertiary:\n":
					line = load();
					compiled.setElement(2, parseElement(line));
					break;
				case "Cards:\n":
					line = load();
					while (!line.equals("DECK END\n")) {
						
					}
					break;
					
			}
			
			line = load();
		}
	}
	
	private Element parseElement(String element) {
		switch (element) {
			case "Time":
				return Element.Time;
			case "Fire":
				return Element.Fire;
			case "Life":
				return Element.Life;
			case "Thunder":
				return Element.Thunder;
			case "Earth":
				return Element.Earth;
			case "Shadow":
				return Element.Shadow;
			case "Water":
				return Element.Water;
			case "Air":
				return Element.Air;
		
		}
		
		return null;
	}
	
	public void initDeckSave() {
		System.out.println("Setting up data storage!");
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
			save.reset();
			System.out.println("Object " + obj + " saved!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object loadObjects() {
		try {
			Object obj = load.readObject();
			
			if(obj instanceof Deck) {
				Deck temp = (Deck) obj;
				System.out.println("Loading: " + obj+ " Id: " + temp.getId());
			} else {
				System.out.println("Loading: " + obj);
			}
			
			return obj;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public void close() {
		try {
			// close streams
			save.close();
			load.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resetDeckLoad() {
		System.out.println("Resetting Deck Loader");
		try {
			loadFile = new FileInputStream("src\\data\\deckSaveFile.sav");
			load = new ObjectInputStream(loadFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// temporary overwrite system
	public boolean overwriteDeck(Deck overwrite) {
		boolean overwritten = false;
		Object obj = loadObjects();
		Deck readIn;
		int overwriteId = overwrite.getId();
		int readInId;
		
		System.out.println("Overwrite deck id: " + overwriteId);
		
		// load all current decks
		try {
			
			System.out.println("Overwrite: " + obj);
			while (obj instanceof Deck) {
				readIn = (Deck) obj;
				readInId = readIn.getId();
				
				System.out.println("Read in deck name: " + readInId);
				
				if (overwriteId == readInId) {
					System.out.println("Overwrite deck found!");
					deckSave.add(overwrite);
					overwritten = true;

				} else {
					deckSave.add(readIn);
				}
				
				obj = loadObjects();
				System.out.println("Obj: " + obj);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Overwrite
		for (Deck deck : deckSave) {
			saveObject(deck);
		}
		
		// clear deckSave
		System.out.println(deckSave.toString());
		deckSave.clear();
		
		if (!overwritten)
			System.out.println("Did not find overwrite deck!");
		
		return overwritten;
	}
	
}
