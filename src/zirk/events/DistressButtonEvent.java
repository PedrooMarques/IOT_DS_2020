/**
 * 
 */
package zirk.events;

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
	public DistressButtonEvent() {
		super(EventType.DISTRESS_BUTTON);
	}

}
