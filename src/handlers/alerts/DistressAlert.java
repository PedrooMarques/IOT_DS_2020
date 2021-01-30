package handlers.alerts;

import i18n.I18N;
import i18n.Messages;

/**
 * @author G16
 *
 */
public class DistressAlert extends Alert {

	private static final long serialVersionUID = 1L;

	public DistressAlert() {
		super(AlertType.DISTRESS);
	}

	public void alert(String location) {
    	String message = I18N.getString(Messages.DISTRESS_ALERT);
    	AlertHandler.getInstance().alert(message);
	}
	
}
