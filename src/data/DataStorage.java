package data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	
	public boolean setupLoad() {
		// load
		try {
			reader = new FileReader("src\\data\\deckSave.txt");
			buffReader = new BufferedReader(reader);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist yet!");
			return false;
		}
		
		return true;
	}
	
	public void save(String text) throws IOException {
		if (text == null) 
			buffWriter.write("null\n");
		else 
			buffWriter.write(text);
	}
	
	public String load() throws IOException {
		String line = buffReader.readLine();
		
		//System.out.println("Read: " + line);
		return line;
	}
	
	public void saveClose() throws IOException {
		buffWriter.close();
	}
	
	public void loadClose() throws IOException {
		buffReader.close();
	}
	
	public Deck buildDeck() throws IOException {
		System.out.println("Building Deck");
		String line;
		Deck compiled = new Deck();
		
		line = load();

		while (line != null && !line.equals("DECK END")) {
			switch (line) {
				case "ID: ":
					line = load();
					Character val = line.charAt(0);
					compiled.setId(Integer.parseInt(val.toString()));
					break;
				case "Name: ":
					line = load();
					compiled.setName(line);
					break;
				case "Primary: ":
					line = load();
					compiled.setElement(0, parseStringToElement(line));
					break;
				case "Secondary: ":
					line = load();
					compiled.setElement(1, parseStringToElement(line));
					break;
				case "Tertiary: ":
					line = load();
					compiled.setElement(2, parseStringToElement(line));
					break;
				case "Cards: ":
					line = load();
					while (!line.equals("Cards End")) {
						compiled.addCard(line);
						line = load();
					}
					break;
			}
			
			line = load();
		}
		
		return compiled;
	}
	
	public Deck[] currentSave() throws IOException {
		if (!isEmpty("src\\data\\deckSave.txt")) {
			String line;
			int i = 0;
			Deck[] decks = new Deck[4];
			
			System.out.println("Checking Current Data");
			
			try {
				if (setupLoad()) {
					line = load();
					
					while (line != null && line.equals("DECK START") && i < 4) {
						decks[i] = buildDeck();
						i++;
						line = load();
					}	
		
					loadClose();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for (Deck deck : decks) {
				if (deck != null) {
					System.out.println("Checked Deck: " + deck.getName() + "ID: " + deck.getId());
					System.out.println("Elements: " + deck.getElement(0) + " " + deck.getElement(1) + " " + deck.getElement(2));
				}
			}

			System.out.println("Data Check Complete");
			return decks;
		}
		
		System.out.println("No Previous Data To Check");
		return null;
	}
	
	public void saveDeck(Deck deck) throws IOException {
		Deck[] decks = currentSave();
		boolean saved = false;
		
		// save setup
		try {
			setupSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// if no decks exist
		if (decks == null) {
			// save first deck
			save("DECK START\r\n");
			save("ID: \n");
			save(Integer.toString(deck.getId()) + "\r\n");
			save("Name: \n");
			save(deck.getName() + "\r\n");
			save("Primary: \n");
			save(parseElementToString(deck.getElement(0)) + "\r\n");
			save("Secondary: \n");
			save(parseElementToString(deck.getElement(1)) + "\r\n");
			save("Tertiary: \n");
			save(parseElementToString(deck.getElement(2)) + "\r\n");
			save("Cards:\r\n");
			for (int j = 0; j < deck.getCards().length; j++) {
				if (deck.getCards()[j] != null)
					save(deck.getCards()[j].getName() + "\r\n");
			}
			save("Cards End\r\n");
			save("DECK END\r\n");
			
		} else {
			// save all current data
			for (int i = 0; i < decks.length; i++) {
				if(decks[i] != null && decks[i].getId() != deck.getId()) {
					
					System.out.println("Saving Deck: " + decks[i].getName());
					
					save("DECK START\r\n");
					save("ID: \n");
					save(Integer.toString(decks[i].getId()) + "\r\n");
					save("Name: \n");
					save(decks[i].getName() + "\r\n");
					save("Primary: \n");
					save(parseElementToString(decks[i].getElement(0)) + "\r\n");
					save("Secondary: \n");
					save(parseElementToString(decks[i].getElement(1)) + "\r\n");
					save("Tertiary: \n");
					save(parseElementToString(decks[i].getElement(2)) + "\r\n");
					save("Cards:\r\n");
					for (int j = 0; j < decks[i].getCards().length; j++) {
						if (decks[i].getCards()[j] != null)
							save(decks[i].getCards()[j].getName() + "\r\n");
					}
					save("Cards End\r\n");
					save("DECK END\r\n");			
				} else {
					if (!saved) {
						
						System.out.println("Saving New Deck: " + deck.getName());
						
						// save new deck/overwrite
						save("DECK START\r\n");
						save("ID: \n");
						save(Integer.toString(deck.getId()) + "\r\n");
						save("Name: \n");
						save(deck.getName() + "\r\n");
						save("Primary: \n");
						save(parseElementToString(deck.getElement(0)) + "\r\n");
						save("Secondary: \n");
						save(parseElementToString(deck.getElement(1)) + "\r\n");
						save("Tertiary: \n");
						save(parseElementToString(deck.getElement(2)) + "\r\n");
						save("Cards:\r\n");
						for (int j = 0; j < deck.getCards().length; j++) {
							if (deck.getCards()[j] != null)
								save(deck.getCards()[j].getName() + "\r\n");
						}
						save("Cards End\r\n");
						save("DECK END\r\n");
						
						saved = true;
					}
				}
					
			}
		}
		
		saveClose();
				
	}
	
	private boolean isEmpty(String file) {
		FileReader read;
		try {
			read = new FileReader(file);
			BufferedReader buffRead = new BufferedReader(read);
			
			if(buffRead.readLine() == null)
				return true;
			else
				return false;
			
		} catch (IOException e) {
			return true;
		}
		
	}
	
	private Element parseStringToElement(String element) {
		if (element == null)
			return null;
		
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
	
	private String parseElementToString(Element element) {
		if (element == null)
			return null;
			
		switch (element) {
			case Time:
				return "Time";
			case Fire:
				return "Fire";
			case Life:
				return "Life";
			case Thunder:
				return "Thunder";
			case Earth:
				return "Earth";
			case Shadow:
				return "Shadow";
			case Water:
				return "Water";
			case Air:
				return "Air";
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
