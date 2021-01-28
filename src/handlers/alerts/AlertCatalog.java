package handlers.alerts;

import java.io.IOException;
import java.util.ArrayList;

import handlers.ICatalog;
import helpers.PersistanceManager;

public class AlertCatalog implements ICatalog<Alert> {

	private ArrayList<Alert> alerts;
	private PersistanceManager<ArrayList<Alert>> persistenceManager;
	
	public AlertCatalog() {
		this.alerts = new ArrayList<Alert>();
		this.persistenceManager = new PersistanceManager<ArrayList<Alert>>("alerts.db");
		try {
			this.alerts = this.persistenceManager.read();
		} catch (IOException | ClassNotFoundException e) {}
	}

	public ArrayList<Alert> list() {
		return this.alerts;
	}

	public Alert add(Alert alert) {
		this.alerts.add(alert);
		try {
			this.persistenceManager.write(this.alerts);
		} catch (IOException e) {}
		return alert;
	}

	public Alert remove(Alert alert) {
		this.alerts.remove(alert);
		try {
			this.persistenceManager.write(this.alerts);
		} catch (IOException e) {}
		return alert;
	}

}
