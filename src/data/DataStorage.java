package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataStorage implements Serializable {

	private static final long serialVersionUID = 1752536480676738644L;
	
	// Saving
	FileOutputStream saveFile;
	ObjectOutputStream save;
	
	// Loading
	FileInputStream loadFile;
	ObjectInputStream load;

	public DataStorage() {
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
			Object obj = load.readObject();
			
			return obj;
			
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
}
