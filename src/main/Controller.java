package main;

import java.util.ArrayList;
import java.util.Date;

import data.EventList;
import data.SchedEvent;
import data.SchedEvent.Builder;


/**
 * Implementation for the controller in the MVC. 
 * The views shall only communicate with the controller and not edit the data directly.
 * TODO: quite a lot
 *	needs to interact with the view, so it needs to know the views
 * @author Dustin Steinack
 *
 */
public class Controller {
	
	private EventList eventList; // This is THE model
	private ArrayList<View> registeredViews;
	
	/**
	 * Creates a new controller which is responsible for coordinating the communication 
	 * Maybe done in the main class?
	 * @param eventList
	 */
	public Controller(EventList eventList) {
		this.eventList = eventList;
		registeredViews = new ArrayList<View>();
		
	}
	
	/**
	 * Takes the input parameters from the GUI, creates a new event and put it to the list
	 * Assuming the GUI provides Date Objects
	 * @param start
	 * @param end
	 * @param name
	 * @param description
	 * @return
	 */
	public SchedEvent addNewEvent(Date start, Date end, String name, String description) {
		SchedEvent event = new SchedEvent(start, end, name, description);
		eventList.addEvent(event);
		
		// TODO: Update List view
		
		return event;
	}
	
	/**
	 * Takes the input parameters from the GUI, creates a new event and put it to the list
	 * Assuming the GUI provides day, month and year fields
	 * @param start
	 * @param end
	 * @param name
	 * @param description
	 * @return
	 */
	public SchedEvent addNewEvent(int dayStart, int monthStart, int yearStart, int dayEnd, int monthEnd, int yearEnd, String name, String description) {
		// Okay I begin to like your builder :)
		Builder eventBuilder = new SchedEvent.Builder(yearStart, monthStart, dayStart);
		eventBuilder.endDate(yearEnd, monthEnd, dayEnd);
		eventBuilder.description(description);
		eventBuilder.name(name);
		
		SchedEvent event = eventBuilder.build();		
		
		eventList.addEvent(event);
		
		// TODO: Update List view
		
		return event;
	}
	
	public SchedEvent editEvent(SchedEvent event) {
		// TODO: Get event from list. Please provide a functions for this
		
		// TODO: Change attributes
		
		// TODO: Update in data and view
		
		return event;
	}
	
	public EventList getEventModel() {
		return eventList;
	}
	
	/**
	 * Register a new view to the controller. The controller will inform the view about any changes concerning the model
	 * @param newView
	 */
	public void registerView(View newView) {
		registeredViews.add(newView);
	}
	
	/**
	 * This methods calls the updateView function for all registered views.
	 */
	public void updateViews() {
		for(View v : registeredViews) {
			System.out.println("Update");
			v.updateView(eventList);
		}
		
	}

}
