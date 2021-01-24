package zirk.events;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class MotionDetectionEvent extends DeviceEvent {
	
	private static final long serialVersionUID = 1L;
	private final String detectionArea;
    private final LocalDateTime timestamp;

	/**
	 * @param detectionArea
	 * @param detected
	 * @param timestamp
	 */
	public MotionDetectionEvent(String detectionArea, LocalDateTime timestamp) {
		this.detectionArea = detectionArea;
		this.timestamp = timestamp;
	}

	/**
	 * @return the detectionArea
	 */
	public String getDetectionArea() {
		return detectionArea;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
    
    //TODO toString

}
