/**
 * 
 */
package zirk.events;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

import ui.output.LightSignals;

/**
 * @author G16
 *
 */
public class LightSignalEvent extends DeviceEvent {
	
	private static final long serialVersionUID = 1L;
	
	private LightSignals lightSignal;

	/**
	 * @param eventType
	 * @param dateTime
	 */
	public LightSignalEvent(LocalDateTime dateTime, LightSignals lightSignal) {
		super(EventType.LIGHT_SIGNAL, dateTime);
		this.lightSignal = lightSignal;
	}

	/**
	 * @return the lightSignal
	 */
	public LightSignals getLightSignal() {
		return lightSignal;
	}

}
