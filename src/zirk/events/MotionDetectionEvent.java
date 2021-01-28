package zirk.events;

/**
 * @author G16
 *
 */
public class MotionDetectionEvent extends DeviceEvent {
	
	private static final long serialVersionUID = 1L;
	private final String detectionArea;

	/**
	 * @param detectionArea
	 */
	public MotionDetectionEvent(String detectionArea) {
		super(EventType.MOTION_DETECTION);
		this.detectionArea = detectionArea;
	}

	/**
	 * @return the detectionArea
	 */
	public String getDetectionArea() {
		return detectionArea;
	}

}
