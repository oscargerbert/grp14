package data;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

/**
 * The application's underlying model. Has a list of all time events
 * and provides proper methods to get and edit the data.
 * @author Andreas Lindmark & ...
 *
 */
public class EventList implements java.io.Serializable, TableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<SchedEvent> eventList;

	public EventList() {
		eventList = new ArrayList<SchedEvent>();
	}

	/**
	 * Adds a new event.
	 * 
	 * @param event
	 */
	public void addEvent(SchedEvent event) {
		SchedEvent t;
		
		/*
		 * Instead of adding the element last in the list, the elements are
		 * inserted in ascending order according to their starting date.
		 */
		for (int i = 0; i < eventList.size(); i++) {
			t = eventList.get(i);
			if (event.getStartingDate().before(t.getStartingDate())) {
				eventList.add(i, event);
				return;
			}
		}
		
		eventList.add(event);
	}
	
	/**
	 * Print the contents in the order they appear in the list.
	 */
	public void print(){
		for (SchedEvent e : eventList){
			System.out.println(e.getStartingDate().toString());
		}
	}
	
	/**
	 * Get the list of all events in this container.
	 * @return
	 */
	public ArrayList<SchedEvent> getEvents(){
		return eventList;
	}
	
	/*
	 * Part for the TableModel - just for testing purpose! 
	 */

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
		case 0:
			return Date.class;
		case 1:
			return Date.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4: 
			return String.class;
					
		}
		return null;
			
	}

	@Override
	public int getColumnCount() {
		/*
		 * 0: Date of Beginning
		 * 1: Date of Ending
		 * 2: Title
		 * 3: Category
		 * 4: Priority
		 * 
		 */

		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:
			return "Start";
		case 1:
			return "Due to";
		case 2:
			return "Title";
		case 3:
			return "Category";
		case 4: 
			return "Priority";
					
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return eventList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return eventList.get(rowIndex).getStartingDate();
		case 1:
			return eventList.get(rowIndex).getStartingDate();
		case 2:
			return eventList.get(rowIndex).getName();
		case 3:
			return "";
		case 4: 
			return "";
					
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	public void setEvents(ArrayList<SchedEvent> readObject) {
		eventList = readObject;
		
	}
}
