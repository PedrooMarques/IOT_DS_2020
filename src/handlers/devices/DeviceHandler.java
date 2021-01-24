package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import zirk.events.DeviceEvent;

public class DeviceHandler {

	private static DeviceHandler instance;

	private DeviceHandler() {
		
	}

	public static DeviceHandler getInstance() {
		if (instance == null) {
			instance = new DeviceHandler();
		}
		return instance;
	}

	public void handleEvent(DeviceEvent event, ZirkEndPoint sender) {
		
	}

	public void sendEvent(DeviceEvent event, Device device) {
		
	}

}