/**
 * 
 */
package models;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class DistressAlert extends Alerts {

	private LocalDateTime timeStamp;
	
	/**
	 * @param alertType
	 */
	public DistressAlert(AlertType alertType) {
		super(alertType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
}
