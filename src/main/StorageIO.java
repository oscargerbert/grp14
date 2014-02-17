package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.EventList;
import data.SchedEvent;

/**
 * Simple framework for saving and loading the events.
 * @author Henrik Brännlund
 *
 */
public class StorageIO {
	private String home;
	private static String fileName = "/storage.txt";

	/**
	 * Constructor. Sets class parameters.
	 */
	public StorageIO() {
		home = System.getProperty("user.home");
	}

	/**
	 * Loads and returns an Events object from a locally stored file.
	 * 
	 * @return An Events object.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public EventList loadEvents() throws IOException, ClassNotFoundException {
		File file = new File(home + fileName);
		byte[] data = new byte[(int) file.length()];
		FileInputStream fileIn = new FileInputStream(file);
		fileIn.read(data);

		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bais);
		EventList eNew = new EventList();
		eNew.setEvents((ArrayList<SchedEvent>) ois.readObject());

		fileIn.close();
		bais.close();
		ois.close();
		return eNew;

		/* old stuff below */
		// EventList e = null;
		// FileInputStream fileIn = new FileInputStream(home + fileName);
		// ObjectInputStream in = new ObjectInputStream(fileIn);
		// e = (EventList) in.readObject();
		// if (e == null) {
		// fileIn.close();
		// in.close();
		// EventList eNew = new EventList();
		// saveEvents(eNew);
		// return eNew;
		// }
		// validateObject(e);
		// fileIn.close();
		// in.close();
		// return e;
	}

	/**
	 * Saves an Events object to a locally stored file.
	 * 
	 * @param e
	 *            An initialization of an Events object.
	 * @throws IOException
	 */
	public void saveEvents(EventList e) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(e.getEvents());
		oos.close();
		baos.close();
		byte[] data = baos.toByteArray();

		FileOutputStream fos = new FileOutputStream(home + fileName);
		fos.write(data);
		fos.close();

		/* old stuff below */
		// FileOutputStream fileOut = new FileOutputStream(home + fileName);
		// ObjectOutputStream out = new ObjectOutputStream(fileOut);
		// out.writeObject(e);
		// fileOut.close();
		// out.close();
	}

	/**
	 * Creates and returns a new profile
	 * 
	 * @return
	 * @throws IOException
	 */
	public EventList CreateNewProfile() throws IOException {
		// make empty events
		EventList e = new EventList();

		// save events
		saveEvents(e);

		// Return events
		return e;
	}
}
