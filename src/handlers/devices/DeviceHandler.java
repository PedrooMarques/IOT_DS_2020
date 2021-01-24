package handlers.devices;

public class DeviceHandler {

	private static DeviceHandler instance;

	public static DeviceHandler getInstance() {
		if (instance == null) {
			instance = new DeviceHandler();
		}
		return instance;
	}

	public void handleEvent(DeviceEvent event) {
		
	}

}
