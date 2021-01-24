import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.devices.DeviceHandler;

import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;

public aspect LightSignals {

	pointcut lightSingalEventDetected(DeviceEvent event, ZirkEndPoint sender) :
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);
	
	void around(DeviceEvent event, ZirkEndPoint sender) : lightSingalEventDetected(event, sender){
		
		//Check if this event is of interest
        if (event instanceof LightSignalEvent) {
        	
        }
	}
}