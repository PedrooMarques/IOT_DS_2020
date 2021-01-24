package handlers.warnings;

import java.time.LocalDateTime;

public class Warning {

	private String name;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	// this frequency can be hours minutes etc...
	private int frequency;
	
	/**
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param frequency
	 */
	public Warning(String name, LocalDateTime startDate, LocalDateTime endDate, int frequency) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequency = frequency;
	}

	public String getWarningName() {
		return this.name;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public int getFrequency() {
		return this.frequency;
	}

}
