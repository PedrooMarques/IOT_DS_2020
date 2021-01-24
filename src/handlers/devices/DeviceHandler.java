package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;

import zirk.devices.Device;
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
		// This method is implemented in aspects
	}

	public void sendEvent(DeviceEvent event, Device device) {
		// This method is implemented in aspects
	}

}
