package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

/**
 * @author G16
 *
 */
public class DistressAlert extends Alert {

	public DistressAlert() {
		super(AlertType.DISTRESS);
	}

	public void alert(String location) {
		String defaultMessage = "Distress Alert!";
    	String message = I18N.getString(Messages.DISTRESS_ALERT, defaultMessage);
    	AlertHandler.getInstance().alert(message);
	}
	
}
