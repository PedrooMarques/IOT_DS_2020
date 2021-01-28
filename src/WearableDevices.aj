import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.devices.DeviceHandler;
import ui.output.Output;
import ui.output.LightSignalType;
import zirk.devices.Device;
import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;

public aspect WearableDevices {
	
	pointcut lightSignalEventDetected(DeviceEvent event, Device device):
		call(void DeviceHandler.sendEvent(DeviceEvent, ZirkEndPoint)) && args(event, device);
	
	void around(DeviceEvent event, Device device): lightSignalEventDetected(event, device) {
        if (event instanceof LightSignalEvent) {
        	DeviceHandler.getInstance().sendEvent(event, device);
        	System.err.println("Sending Light Signal event to Wearable");
        }
	}

	void around(): execution(void Output.showWarning()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent(LightSignalType.YELLOW);
		DeviceHandler.getInstance().sendEvent(event, null);
	}

	void around(): execution(void Output.showAlert()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent(LightSignalType.RED);
		DeviceHandler.getInstance().sendEvent(event, null);
	}
}
