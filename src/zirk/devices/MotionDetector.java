/**
 * 
 */
package zirk.devices;

import static i18n.Messages.DEVICE_RUNNING;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import devices.DeviceType;
import i18n.I18N;
import zirk.events.MotionDetectionEvent;

/**
 * @author G16
 *
 */
public class MotionDetector extends Device {

	public MotionDetector() {
		super(DeviceType.MOTION_DETECTOR);
	}
	
	public void sendMotionDetection() {
		//produces some  values since this is a mock
        final String detectionArea = "Cozinha";
        final LocalDateTime timeStamp = LocalDateTime.now();
        final MotionDetectionEvent motionDetectorDetectionEvent = new MotionDetectionEvent(detectionArea, timeStamp);

        //sends the event
        bezirk.sendEvent(motionDetectorDetectionEvent);
        System.err.println("Published motion detection: " + motionDetectorDetectionEvent.toString());
	}

}
