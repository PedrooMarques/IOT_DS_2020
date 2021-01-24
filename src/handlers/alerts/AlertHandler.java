package handlers.alerts;

import ui.output.Output;

public class AlertHandler {

	private static AlertHandler instance;
	private AlertCatalog alerts;

	private AlertHandler() {
		this.alerts = new AlertCatalog();
	}

	public static AlertHandler getInstance() {
		if (instance == null) {
			instance = new AlertHandler();
		}
		return instance;
	}
	
	public AlertCatalog getAlerts() {
		return this.alerts;
	}

	public void alert(String message) {
		Output.getInstance().showAlert(message);
		ContactHandler.getInstance().sendEmergencySMS(message);
	}

	public void handleMotionDetection(MotionDetectionEvent event) {
		for (Alert alert: this.alerts.getAlertList()) {
			if (alert instanceof MotionDetectionAlert) {
				((MotionDetectionAlert) alert).alert();
			}
			if (alert instanceof InactivityAlert) {
				((InactivityAlert) alert).cancel();
			}
		}
	}

}
