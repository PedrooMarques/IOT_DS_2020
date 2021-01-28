import com.bezirk.middleware.addressing.ZirkEndPoint;
import handlers.devices.DeviceHandler;
import handlers.alerts.AlertHandler;
import zirk.events.DeviceEvent;
import zirk.events.MotionDetectionEvent;

public aspect MotionDetector {

	pointcut motionDetectionEventDetected(DeviceEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);

	void around(DeviceEvent event, ZirkEndPoint sender): motionDetectionEventDetected(event, sender) {
        if (event instanceof MotionDetectionEvent) {
        	AlertHandler.getInstance().handleMotionDetection((MotionDetectionEvent)event);
        	System.err.println("Received Motion Detection event from Motion Detector");
        }
	}
}
