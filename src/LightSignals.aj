import ui.output.Output;
import zirk.events.LightSignalEvent;
import handlers.devices.DeviceHandler;

public aspect LightSignals {

	void around(): execution(void Output.showAlert()) {
		proceed();
		LightSignalEvent event = new LightSignalEvent();
		DeviceHandler.getInstance().sendEvent(event, null);
	}

}
