/**
 * 
 */
package models;
/**
 * @author G16
 *
 */
public abstract class Alerts {
	
	private AlertType alertType;
	
	/**
	 * @param alertType
	 */
	public Alerts(AlertType alertType) {
		this.alertType = alertType;
	}

	/**
	 * @return the alertType
	 */
	public AlertType getTipoAlerta() {
		return alertType;
	}	
	
}
