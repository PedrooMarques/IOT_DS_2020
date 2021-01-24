import java.time.LocalDateTime;
import handlers.devices.DeviceHandler;
import ui.output.LightSignals;
import zirk.devices.Device;
import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import ui.output.Output;

public aspect WearableDevices {
	
	pointcut lightSignalEventDetected(DeviceEvent event, Device device):
		call(void DeviceHandler.sendEvent(DeviceEvent, ZirkEndPoint)) && args(event, device);
	
	void around(DeviceEvent event, Device device): lightSignalEventDetected(event, device) {
        if (event instanceof LightSignalEvent) {
        	DeviceHandler.getInstance().sendEvent(new LightSignalEvent(LocalDateTime.now(), ((LightSignalEvent) event).getLightSignal()), device);
        }
	}

	void around(): execution(void Output.showWarning()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent(LocalDateTime.now(), LightSignals.RED);
		DeviceHandler.getInstance().sendEvent(event, null);
	}

	void around(): execution(void Output.showAlert()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent(LocalDateTime.now(), LightSignals.YELLOW);
		DeviceHandler.getInstance().sendEvent(event, null);
	}
}
