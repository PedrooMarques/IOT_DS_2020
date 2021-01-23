package zirk.events;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public abstract class DeviceEvent extends Event {

	private static final long serialVersionUID = 1L;
	private final LocalDateTime timestamp;

	public DeviceEvent() {
		super();
		this.timestamp = new LocalDateTime();
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

}
