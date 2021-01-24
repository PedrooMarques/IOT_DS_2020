package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

/**
 * @author G16
 *
 */
public class MotionDetectionAlert extends Alert {

	private String location;

	public MotionDetectionAlert() {
		super(AlertType.MOTION_DETECTION);
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}

	public void alert() {
		String defaultMessage = "Mostion Detection Alert! {0}";
    	String message = I18N.getString(Messages.MOTION_DETECTION_ALERT, defaultMessage, this.location);
    	AlertHandler.getInstance().alert(message);
	}

}
