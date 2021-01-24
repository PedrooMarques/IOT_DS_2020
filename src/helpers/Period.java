package helpers;

import java.time.LocalTime;

/**
 * 
 */

/**
 * @author G16
 *
 */
public class Period {
	
	LocalTime startTime, endTime;

	/**
	 * 
	 */
	public Period(LocalTime startTime, LocalTime endTime) {
		
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

}
