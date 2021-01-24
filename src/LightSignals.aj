import ui.output.Output;
import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;
import handlers.devices.DeviceHandler;

public aspect LightSignals {

	pointcut lightSingalEventDetected(DeviceEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);
	
	void around(DeviceEvent event, ZirkEndPoint sender) : lightSingalEventDetected(event, sender) {
        if (event instanceof LightSignalEvent) {
        	
        }
	}

	void around(): execution(void Output.showAlert()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent();
		DeviceHandler.getInstance().sendEvent(event, null);
	}

}
