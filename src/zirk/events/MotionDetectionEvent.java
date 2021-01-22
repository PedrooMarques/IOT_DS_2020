package zirk.events;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;
/**
 * @author G16
 *
 */
public class MotionDetectionEvent extends Event {
	
	private static final long serialVersionUID = 1L;

	final String detectionArea;
    final boolean detected;
    final LocalDateTime timeStamp;
	/**
	 * @param detectionArea
	 * @param detected
	 * @param timeStamp
	 */
	public MotionDetectionEvent(String detectionArea, boolean detected, LocalDateTime timeStamp) {
		this.detectionArea = detectionArea;
		this.detected = detected;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the detectionArea
	 */
	public String getDetectionArea() {
		return detectionArea;
	}
	/**
	 * @return the detected
	 */
	public boolean isDetected() {
		return detected;
	}
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
    
    //TODO toString

}
