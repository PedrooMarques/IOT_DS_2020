package devices;

import java.time.LocalDateTime;
import java.util.Timer;

import zirk.events.MotionDetectionEvent;

public class MotionDetector extends DeviceSimulator {

	public MotionDetector() {
		super(DeviceType.MOTION_DETECTOR);
	}

	public static void main(String[] args) {
		MotionDetector motionDetectorZirk = new MotionDetector();
		System.out.println("Running Motion Detector Simulator");
        TimerTask task = new TimerTask() {
            public void run() {
            	String detectionArea = "Area";
                LocalDateTime timestamp = LocalDateTime.now();
                MotionDetectionEvent motionDetectionEvent = new MotionDetectionEvent(detectionArea, timestamp);
                motionDetectorZirk.bezirk.sendEvent(motionDetectionEvent);
                System.err.println("Published Motion Detection event");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 5000);
	}

}
