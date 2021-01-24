import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.devices.DeviceHandler;

import zirk.events.DeviceEvent;
import zirk.events.MotionDetectionEvent;

public aspect MotionDetection {
	
	pointcut motionEventDetected(DeviceEvent event, ZirkEndPoint sender) :
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);
	
	void around(DeviceEvent event, ZirkEndPoint sender) : motionEventDetected(event, sender){
		
		//Check if this event is of interest
        if (event instanceof MotionDetectionEvent) {
        	
        }
	}
}