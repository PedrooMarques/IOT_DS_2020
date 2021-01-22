/**
 * 
 */
package zirk.sensors;

import static i18n.Messages.DEVICE_RUNNING;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import i18n.I18N;

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
        final boolean detected = true;
        final LocalDateTime timeStamp = LocalDateTime.now();
        final MotionDetectorDetectionEvent motionDetectorDetectionEvent = new MotionDetectorDetectionEvent(detectionArea, detected, timeStamp);

        //sends the event
        bezirk.sendEvent(motionDetectorDetectionEvent);
        System.err.println("Published air quality update: " + motionDetectorDetectionEvent.toString());
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
        //motionDetectionSensorZirk.sendPeriodiclyAirQualityUpdate();
	}

}
