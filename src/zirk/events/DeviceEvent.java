package zirk.events;

import java.time.LocalDateTime;

import com.bezirk.middleware.messages.Event;

public abstract class DeviceEvent extends Event {

	private static final long serialVersionUID = 1L;
	protected final EventType eventType;
	protected final LocalDateTime timestamp;

	public DeviceEvent(EventType eventType) {
		super();
		this.eventType = eventType;
		this.timestamp = LocalDateTime.now();
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	/**
	 * @return the eventType
	 */
	public EventType getEventType() {
		return eventType;
	}

}
