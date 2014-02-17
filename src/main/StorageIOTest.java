package main;
import java.io.IOException;

import main.StorageIO;
import static org.junit.Assert.*;

import org.junit.Test;

// Not really used 
public class StorageIOTest extends StorageIO{

	@Test
	public void testStorageIO() throws ClassNotFoundException, IOException {
		assertNotNull("Event", loadEvents());
		fail("Not yet implemented");
	}

	@Test
	public void testLoadEvents() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveEvents() {
		fail("Not yet implemented");
	}

}
