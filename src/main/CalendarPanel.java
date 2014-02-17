/**
 * 
 */
package main;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.EventList;

/**
 * This class will cotain the code for the calendar view. 
 * @author dustin
 *
 */
public class CalendarPanel extends JPanel implements View {
	
	private Controller controller;
	
	
	public CalendarPanel(Controller c) {
		// Register controller
		controller = c;
		c.registerView(this);
		
		// some GUI
		setLayout(new FlowLayout());
		JLabel info = new JLabel("Sorry not implemented yet! Try TaskView!");
		add(info);
	}
	

	/* (non-Javadoc)
	 * @see main.View#updateView(data.EventList)
	 */
	@Override
	public void updateView(EventList events) {
		// TODO Auto-generated method stub

	}

}
