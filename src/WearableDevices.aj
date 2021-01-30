import handlers.devices.DeviceHandler;
import ui.output.Output;
import ui.output.LightSignalType;
import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;

public aspect WearableDevices {
	
	pointcut lightSignalEventDetected(DeviceEvent event):
		call(void DeviceHandler.sendEvent(DeviceEvent)) && args(event);
	
	void around(DeviceEvent event): lightSignalEventDetected(event) {
		proceed(event);
        if (event instanceof LightSignalEvent) {
        	System.err.println("Sending Light Signal event to Wearable");
        }
	}

	void around(): execution(void Output.showWarning(..)) {
		proceed();
		System.err.println("**Sending Light Signal: Yellow**");
		LightSignalEvent event = new LightSignalEvent(LightSignalType.YELLOW);
		DeviceHandler.getInstance().sendEvent(event);
	}

	void around(): execution(void Output.showAlert(..)) {
		proceed();
		System.err.println("**Sending Light Signal: Red**");
		LightSignalEvent event = new LightSignalEvent(LightSignalType.RED);
		DeviceHandler.getInstance().sendEvent(event);
	}

}
