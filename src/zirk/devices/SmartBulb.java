/**
 * 
 */
package zirk.devices;

import devices.DeviceType;
import zirk.events.LightSignalEvent;

/**
 * @author G16
 *
 */
public class SmartBulb extends Device {

	public SmartBulb() {
		super(DeviceType.SMART_BULB);
	}

	public void sendEvent(LightSignalEvent event) {
		this.bezirk.sendEvent(event);
	}

}
