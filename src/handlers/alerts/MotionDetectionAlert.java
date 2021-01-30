package handlers.alerts;

/**
 * @author G16
 *
 */
public class MotionDetectionAlert extends Alert {

	private static final long serialVersionUID = 1L;
	private String location;

	public MotionDetectionAlert(String location) {
		super(AlertType.MOTION_DETECTION);
		this.location = location;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}

}
