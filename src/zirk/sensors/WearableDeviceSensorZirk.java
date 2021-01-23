/**
 * 
 */
package zirk.sensors;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import zirk.events.ButtonPressedEvent;
import zirk.events.MotionDetectionEvent;

/**
 * @author G16
 *
 */
public class WearableDeviceSensorZirk {

	private Bezirk bezirk;
	
	/**
	 * 
	 */
	public WearableDeviceSensorZirk() {
		BezirkMiddleware.initialize();
        bezirk = BezirkMiddleware.registerZirk("Wearable Device Zirk");
        System.err.println("Got Bezirk instance");
	}
	
	public void distressButtonPressed() {
		//produces some  values since this is a mock
		final LocalDateTime timeStamp = LocalDateTime.now();
		final ButtonPressedEvent buttonPressedEvent = new ButtonPressedEvent(timeStamp);
		//sends the event
        bezirk.sendEvent(buttonPressedEvent);
        System.err.println("Published button pressed: " + buttonPressedEvent.toString());
	}
	
	public void activityMonitored() {
		//produces some  values since this is a mock
        final String detectionArea = "null";
        final LocalDateTime timeStamp = LocalDateTime.now();
        final MotionDetectionEvent motionDetectorDetectionEvent = new MotionDetectionEvent(detectionArea, timeStamp);

        //sends the event
        bezirk.sendEvent(motionDetectorDetectionEvent);
        System.err.println("Published motion detection: " + motionDetectorDetectionEvent.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
