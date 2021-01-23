/**
 * 
 */
package models;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author G16
 *
 */
public class InactivityAlert extends Alerts {
	
	private int duration;
	private Period period;
	private Duration inactivityDuration;

	/**
	 * @param alertType
	 */
	public InactivityAlert(AlertType alertType) {
		super(alertType);
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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

	/**
	 * @return the inactivityDuration
	 */
	public Duration getInactivityDuration() {
		return inactivityDuration;
	}

	/**
	 * @param inactivityDuration the inactivityDuration to set
	 */
	public void setInactivityDuration(Duration inactivityDuration) {
		this.inactivityDuration = inactivityDuration;
	}

	public void startTimer() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
 
            @Override
            public void run() {
            	inactivityDuration.plusSeconds(1);
            	if (inactivityDuration.toMinutes() >= duration) {
					//TODO
				}
            }
        }, 1000, 1000);
	}

}
