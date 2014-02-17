package main;

import data.EventList;

/**
 * This interface should be implemented by all views (in the sense of the MVC pattern)
 * @author Dustin Steinack
 *
 */
public interface View {
	
	/**
	 * This methods is called when the model (EventList) was changed. The views are asked to update themself.
	 * @param events
	 */
	public void updateView(EventList events);

}
