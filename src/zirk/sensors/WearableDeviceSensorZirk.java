/**
 * 
 */
package zirk.sensors;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

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
		
	}
	
	public void activityMonitored() {
		//produces some  values since this is a mock
        final String detectionArea = "Cozinha";
        final boolean detected = true;
        final LocalDateTime timeStamp = LocalDateTime.now();
        final MotionDetectionEvent motionDetectorDetectionEvent = new MotionDetectionEvent(detectionArea, timeStamp);

        //sends the event
        bezirk.sendEvent(motionDetectorDetectionEvent);
        System.err.println("Published air quality update: " + motionDetectorDetectionEvent.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
