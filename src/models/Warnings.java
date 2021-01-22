/**
 * 
 */
package models;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class Warnings {
	
	private String warningName;
	private LocalDateTime startDate, endDate;
	// this frequency can be hours minutes etc...
	private int frequency;
	
	/**
	 * @param warningName
	 * @param startDate
	 * @param endDate
	 * @param frequency
	 */
	public Warnings(String warningName, LocalDateTime startDate, LocalDateTime endDate, int frequency) {
		this.warningName = warningName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequency = frequency;
	}

	public String getWarningName() {
		return warningName;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public int getFrequency() {
		return frequency;
	}

}
