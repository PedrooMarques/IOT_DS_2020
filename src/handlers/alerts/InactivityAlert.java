package handlers.alerts;

import java.util.Timer;
import java.util.TimerTask;

import i18n.I18N;
import i18n.Messages;

/**
 * @author G16
 *
 */
public class InactivityAlert extends Alert {
	
	private final int durationMinutes;
	private final Timer timer;

	/**
	 * @param alertType
	 */
	public InactivityAlert(int durationMinutes) {
		super(AlertType.INACTIVITY);
		this.durationMinutes = durationMinutes;
		this.timer = new Timer();
		timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	String defaultMessage = "Inactivity Alert! {0} minutes";
            	int minutes = durationMinutes / 1000 / 60;
            	String message = I18N.getString(Messages.INACTIVITY_ALERT, defaultMessage, Integer.toString(minutes));
            	AlertHandler.getInstance().alert(message);
            }
        }, this.durationMinutes);
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
