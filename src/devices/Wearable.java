package devices;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import zirk.events.DistressButtonEvent;
import zirk.events.LightSignalEvent;

public class Wearable extends DeviceSimulator {

	public Wearable() {
		super(DeviceType.WEARABLE);
	}
	
	public static void main(String[] args) {
		Wearable wearableZirk = new Wearable();
		SmartBulb smartBulbZirk = new SmartBulb();
		System.out.println("Running Wearable Device Simulator");
        TimerTask task = new TimerTask() {
            public void run() {
            	LocalDateTime timestamp = LocalDateTime.now();
                DistressButtonEvent distressButtonEvent = new DistressButtonEvent(timestamp);
                wearableZirk.bezirk.sendEvent(distressButtonEvent);
                System.err.println("Published Distress Button event");
            }
        };
        new Timer().scheduleAtFixedRate(task, 0, 5000);
        EventSet lightSignalEvents = new EventSet(LightSignalEvent.class);
        EventReceiver eventReceiver = new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                if (event instanceof LightSignalEvent) {
                	System.out.println("Received Light Signal event");
                }
            }
        };
        lightSignalEvents.setEventReceiver(eventReceiver);
        smartBulbZirk.bezirk.subscribe(lightSignalEvents);
        System.out.println("Subscribed to Wearable Device events");
	}

}
