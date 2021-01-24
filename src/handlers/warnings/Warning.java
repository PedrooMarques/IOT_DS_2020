package handlers.warnings;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import i18n.I18N;
import i18n.Messages;

public class Warning {

	private String name;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Frequency frequency;
	private int frequencyNumber;
	private Timer timer;

	/**
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param frequency
	 * @param frequencyNumber
	 */
	public Warning(String name, LocalDateTime startDate, LocalDateTime endDate, Frequency frequency, int frequencyNumber) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequency = frequency;
		this.frequencyNumber = frequencyNumber;
		Warning w = this;
		TimerTask start = new TimerTask() {
			public void run() {
				w.start();
			}
		};
		new Timer().schedule(start, Duration.between(startDate, LocalDateTime.now()).toMillis());
		TimerTask stop = new TimerTask() {
			public void run() {
				w.timer.cancel();
			}
		};
		new Timer().schedule(stop, Duration.between(endDate, LocalDateTime.now()).toMillis());
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

	public Frequency getFrequency() {
		return this.frequency;
	}

	public int getFrequencyNumber() {
		return this.frequencyNumber;
	}

	private void start() {
		TimerTask task = new TimerTask() {
			public void run() {
				String defaultMessage = "Warning! {0}";
				String message = I18N.getString(Messages.WARNING, defaultMessage, name);
				WarningHandler.getInstance().warn(message);
			}
		};
		int time = 1000;
		switch (this.frequency) {
		case MINUTE:
			time *= 60;
		case HOUR:
			time *= 60;
		case DAY:
			time *= 24;
		case WEEK:
			time *= 7;
		case YEAR:
			time *= 52;
		default:
			break;
		}
		this.timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, time * this.frequencyNumber);
	}

}
