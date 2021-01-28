package handlers.devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import zirk.devices.Device;
import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;
import zirk.events.DeviceEvent;

public class DeviceHandler {

	private static final DeviceHandler INSTANCE = new DeviceHandler();
	
	@Inject @Named("MotionDetector")
	private static MotionDetector motionDetector;
	
	@Inject @Named("SmartBulb")
	private static SmartBulb bulb;
	
	@Inject @Named("Wearable")
	private static Wearable wearable;

	private DeviceHandler() {

	}

	public static DeviceHandler getInstance() {
		return INSTANCE;
	}

	public void handleEvent(DeviceEvent event, ZirkEndPoint sender) {
		// This method is implemented in aspects
	}

	public void sendEvent(DeviceEvent event, Device device) {
		// This method is implemented in aspects
	}

}
