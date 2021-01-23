/**
 * 
 */
package zirk.events;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

/**
 * @author G16
 *
 */
public class ButtonPressedEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	private final LocalDateTime timeStamp;

	/**
	 * @param timeStamp
	 */
	public ButtonPressedEvent(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	  //TODO toString

}
