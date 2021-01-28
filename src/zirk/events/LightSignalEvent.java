/**
 * 
 */
package zirk.events;

import ui.output.LightSignalType;

/**
 * @author G16
 *
 */
public class LightSignalEvent extends DeviceEvent {
	
	private static final long serialVersionUID = 1L;
	
	private LightSignalType lightSignal;

	/**
	 * @param eventType
	 */
	public LightSignalEvent(LightSignalType lightSignal) {
		super(EventType.LIGHT_SIGNAL);
		this.lightSignal = lightSignal;
	}

	/**
	 * @return the lightSignal
	 */
	public LightSignalType getLightSignal() {
		return lightSignal;
	}

}
