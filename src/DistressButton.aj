import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.devices.DeviceHandler;

import zirk.events.DeviceEvent;
import zirk.events.DistressButtonEvent;

public aspect DistressButton {


	pointcut distressButtonEventDetected(DeviceEvent event, ZirkEndPoint sender) :
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);
	
	void around(DeviceEvent event, ZirkEndPoint sender) : distressButtonEventDetected(event, sender){
		
		//Check if this event is of interest
        if (event instanceof DistressButtonEvent) {
        	
        }
	}
}