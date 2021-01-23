/**
 * 
 */
package zirk.sensors;

import static i18n.Messages.DEVICE_RUNNING;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;
import zirk.events.MotionDetectionEvent;

/**
 * @author G16
 *
 */
public class MotionDetectionSensorZirk {
	
	private Bezirk bezirk;

	/**
	 * 
	 */
	public MotionDetectionSensorZirk() {
		BezirkMiddleware.initialize();
        bezirk = BezirkMiddleware.registerZirk("Motion Detector Zirk");
        System.err.println("Got Bezirk instance");
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
	
	//TODO ver o outro metodo, parece opcional mas ver na mesma
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MotionDetectionSensorZirk motionDetectionSensorZirk = new MotionDetectionSensorZirk();
        System.err.println("This product has a Motion Detector Sensor");
        
        //TODO mudar as mensagens que aproveitamos da prof
        System.err.println(I18N.getString(DEVICE_RUNNING, "Air Quality Sensor"));
        motionDetectionSensorZirk.sendMotionDetection();
	}

}
