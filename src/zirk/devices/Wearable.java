package zirk.devices;

import java.time.LocalDateTime;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import devices.DeviceType;
import handlers.devices.DeviceHandler;
import zirk.events.DeviceEvent;
import zirk.events.DistressButtonEvent;
import zirk.events.LightSignalEvent;
import zirk.events.MotionDetectionEvent;

/**
 * @author G16
 *
 */
public class Wearable extends Device{

	public Wearable(Bezirk bezirk) {
		super(bezirk, DeviceType.WEARABLE);
		final DeviceHandler deviceHandler = DeviceHandler.getInstance();
		EventSet events = new EventSet(DistressButtonEvent.class, MotionDetectionEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                deviceHandler.handleEvent((DeviceEvent)event, sender);
            }
        };
        events.setEventReceiver(eventReceiver);
        this.bezirk.subscribe(events);
	}

	public void sendEvent(LightSignalEvent event) {
		this.bezirk.sendEvent(event);
	}

}
