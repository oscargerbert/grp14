package data;

import java.util.ArrayList;


public class Day {
	
	private String year;
	private String month;
	private String day;
	
	
	private ArrayList<SchedEvent> events;

	public Day(){

	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public ArrayList<SchedEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<SchedEvent> events) {
		this.events = events;
	}
	
	
}
