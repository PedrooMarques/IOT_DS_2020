/**
 * 
 */
package handlers.alerts;

import java.io.Serializable;

/**
 * @author G16
 *
 */
public abstract class Alert implements Serializable {

	private static final long serialVersionUID = 1L;
	private AlertType alertType;
	
	/**
	 * @param alertType
	 */
	public Alert(AlertType alertType) {
		this.alertType = alertType;
	}

	/**
	 * @return the alertType
	 */
	public AlertType getAlertType() {
		return alertType;
	}	
	
}
