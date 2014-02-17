package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import data.EventList;
import data.SchedEvent;

/**
 * This class launches the application itself.
 * Initialize IO framework, controller and main window 
 * @author Ganryu
 *
 */

// Main should test to see if there is a storage file.


public class Main{
	
	public static Controller controller; // TODO: no static
	
 public static void main(String[] args) throws ClassNotFoundException, IOException { //TODO: no throws here
	 
	 System.out.println(Date.class);
	 // Init StorageIO
	 StorageIO sio = new StorageIO();
	 
	 EventList e = null;
	 
	 // TODO Fixme
	 try {
		 e = sio.loadEvents();
	 } catch (FileNotFoundException exp) {
		 // This block is triggered if the profile does not exists, create a new one
		 e = sio.CreateNewProfile();
	 }
	 
	 controller = new Controller(e);
	 controller.addNewEvent(3, 1, 2014, 2, 2, 2014, "Test Event 0", "This is a test event");
	 controller.addNewEvent(2, 1, 2014, 2, 5, 2014, "Test Event 2", "This is another test event");
	 controller.addNewEvent(1, 1, 2014, 2, 7, 2014, "Test Event 3" , "This is yet another test event");
	 


	
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                MainWindow f=new MainWindow(controller);
	                f.createAndShowGUI();
	            }
	        });
	    }
}
