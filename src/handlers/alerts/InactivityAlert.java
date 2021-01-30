package handlers.alerts;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author G16
 *
 */
public class InactivityAlert extends Alert {

	private static final long serialVersionUID = 1L;
	private final int durationMinutes;
	private final Timer timer;

	/**
	 * @param alertType
	 */
	public InactivityAlert(int durationMinutes) {
		super(AlertType.INACTIVITY);
		this.durationMinutes = durationMinutes;
		this.timer = new Timer();
		InactivityAlert alert = this;
		timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	AlertHandler.getInstance().alertInactivity(alert);
            }
        }, this.durationMinutes * 60 * 1000);
	}

	/**
	 * @return the duration in minutes
	 */
	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void cancel() {
		this.timer.cancel();
	}

}
