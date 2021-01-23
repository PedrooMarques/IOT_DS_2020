/**
 * 
 */
package models;

/**
 * @author G16
 *
 */
public class MotionDetectionAlert extends Alerts {

	private String area;
	private Period period;
	
	/**
	 * @param alertType
	 */
	public MotionDetectionAlert(AlertType alertType) {
		super(alertType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the period
	 */
	public Period getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
}
