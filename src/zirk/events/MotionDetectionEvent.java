package zirk.events;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class MotionDetectionEvent extends DeviceEvent {
	
	private static final long serialVersionUID = 1L;
	private final String detectionArea;

	/**
	 * @param detectionArea
	 * @param detected
	 * @param timestamp
	 */
	public MotionDetectionEvent(String detectionArea, LocalDateTime timestamp) {
		super(EventType.MOTION_DETECTION, timestamp);
		this.detectionArea = detectionArea;
	}

	/**
	 * @return the detectionArea
	 */
	public String getDetectionArea() {
		return detectionArea;
	}
    
    //TODO toString

}
