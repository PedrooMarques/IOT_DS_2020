/**
 * 
 */
package zirk.events;

import com.bezirk.middleware.messages.Event;

import models.LightSignals;

/**
 * @author G16
 *
 */
public class LightSignalsEvent extends Event {
	
	private static final long serialVersionUID = 1L;

	private LightSignals signal;

	/**
	 * @param signal
	 */
	public LightSignalsEvent(LightSignals signal) {
		this.signal = signal;
	}

	/**
	 * @return the signal
	 */
	public LightSignals getSignal() {
		return signal;
	}
	
	//TODO toString

}
