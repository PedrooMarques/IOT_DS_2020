package handlers.alerts;

import handlers.contacts.ContactHandler;
import i18n.I18N;
import i18n.Messages;
import ui.output.Output;
import zirk.events.DistressButtonEvent;
import zirk.events.MotionDetectionEvent;

public class AlertHandler {

	private static final AlertHandler INSTANCE = new AlertHandler();
	private AlertCatalog alerts;

	private AlertHandler() {
		this.alerts = new AlertCatalog();
	}

	public static AlertHandler getInstance() {
		return INSTANCE;
	}
	
	public AlertCatalog getAlerts() {
		return this.alerts;
	}

	public void alert(String message) {
		Output.getInstance().showAlert(message);
		ContactHandler.getInstance().sendEmergencySMS(message);
	}

	public void handleMotionDetection(MotionDetectionEvent event) {
		for (Alert alert: this.alerts.list()) {
			if (alert instanceof MotionDetectionAlert) {
				((MotionDetectionAlert)alert).alert();
			}
			if (alert instanceof InactivityAlert) {
				((InactivityAlert)alert).cancel();
			}
		}
	}

	public void handleEmergency(DistressButtonEvent event) {
		String message = I18N.getString(Messages.DISTRESS_BUTTON_DETECTED);
		this.alert(message);
	}

}
