package helpers;

import java.lang.Runnable;

public class MenuChoice {

	private final String message;
	private final Runnable task;

	public MenuChoice(String message, Runnable task) {
		super();
		this.message = message;
		this.task = task;
	}

	public String getMessage() {
		return this.message;
	}

	public Runnable getTask() {
		return this.task;
	}

	public void run() {
		this.runnable.run();
	}

}
