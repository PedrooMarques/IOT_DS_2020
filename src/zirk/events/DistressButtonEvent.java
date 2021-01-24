/**
 * 
 */
package zirk.events;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class DistressButtonEvent extends DeviceEvent {

	private static final long serialVersionUID = 1L;

	/**
	 * @param eventType
	 * @param dateTime
	 */
	public DistressButtonEvent(LocalDateTime timeStamp) {
		super(EventType.DISTRESS_BUTTON, timeStamp);
	}

	

}
