package devices;

import java.util.Timer;
import java.util.TimerTask;

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
                MotionDetectionEvent motionDetectionEvent = new MotionDetectionEvent(detectionArea);
                motionDetectorZirk.bezirk.sendEvent(motionDetectionEvent);
                System.err.println("Published Motion Detection event");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 5000);
	}

}
