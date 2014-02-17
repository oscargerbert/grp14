package data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * This is an event class that represents an event in the scheduler.
 * 
 * @author Ganryu
 * 
 */
public class SchedEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	// This is the starting date of the event
	private Date startDate;
	// This is the ending date of the event
	private Date endDate;
	private String name;
	private String description;
	private boolean done;

	/**
	 * Constructor for SchedEvent. 
	 * @param start
	 * @param end
	 * @param name
	 * @param description
	 * @author Ganryu
	 */
	public SchedEvent(Date start, Date end, String name, String description){
		startDate = start;
		endDate = end;
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Constructor for use with Builder
	 * @param b
	 */
	private SchedEvent(Builder b) {
		this.startDate = b.startDate;
		this.endDate = b.endDate;
		this.name = b.name;
		this.description = b.description;
	}

	/**
	 * Gets the starting date of this event
	 * 
	 * @return
	 */
	public Date getStartingDate() {
		return startDate;
	}

	/**
	 * Get the name of this event
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of this event
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the ending date of this event
	 * 
	 * @return
	 */
	public Date getEndingDate() {
		return endDate;
	}

	/**
	 * Builder for creating new SchedEvents.
	 * 
	 * @author Ganryu
	 * 
	 */
	public static class Builder {
		private Date startDate;
		private Date endDate;
		private String name;
		private String description;

		/**
		 * Constructor for Builder. Supply starting date.
		 * @param year
		 * @param month
		 * @param day
		 */
		public Builder(int year, int month, int day) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, day);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			startDate = calendar.getTime();
			endDate = calendar.getTime();
			name = "unnamed";
			description = "no description";
		}

		/**
		 * Provide a name for the event.
		 * @param name
		 * @return
		 */
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		/**
		 * Provide a description for the event.
		 * @param descr
		 * @return
		 */
		public Builder description(String descr) {
			this.description = descr;
			return this;
		}

		/**
		 * Set end date.
		 * @param year
		 * @param month
		 * @param day
		 * @return
		 */
		public Builder endDate(int year, int month, int day){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, day);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			endDate = calendar.getTime();
			
			// Make sure end date is not before start date.
			if (endDate.before(startDate)){
				endDate = startDate;
			}
			
			return this;
		}
		
		/**
		 * Build the event.
		 * @return
		 */
		public SchedEvent build() {
			return new SchedEvent(this);
		}
	}
}
