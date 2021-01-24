package handlers.alerts;

import java.util.ArrayList;

public class AlertCatalog {

	private ArrayList<Alert> alerts;
	
	public AlertCatalog() {
		this.alerts = new ArrayList<Alert>();
	}

	public ArrayList<Alert> getAlertList() {
		return this.alerts;
	}

	public Alert addAlert(Alert alert) {
		this.contacts.add(alert);
		return alert;
	}

	public Alert removeAlert(Alert alert) {
		this.contacts.remove(alert);
		return alert;
	}

}
