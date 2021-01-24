import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import zirk.events.DeviceEvent;
import zirk.events.MotionDetectionEvent;
import handlers.devices.DeviceHandler;

public aspect ActivityMonitor {

	pointcut motionDetectionEventDetected(DeviceEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);

	void around(DeviceEvent event, ZirkEndPoint sender): motionDetectionEventDetected(event, sender) {
        if (event instanceof MotionDetectionEvent) {
        	AlertHandler.getInstance().handleMotionDetection((MotionDetectionEvent)event);
        }
	}

}
