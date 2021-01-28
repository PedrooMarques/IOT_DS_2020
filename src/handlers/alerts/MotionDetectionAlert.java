package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

/**
 * @author G16
 *
 */
public class MotionDetectionAlert extends Alert {

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

	public void alert() {
    	String message = I18N.getString(Messages.MOTION_DETECTION_ALERT, this.location);
    	AlertHandler.getInstance().alert(message);
	}

}
