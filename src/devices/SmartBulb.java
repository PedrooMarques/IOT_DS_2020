package devices;

import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;
import com.bezirk.middleware.messages.EventSet.EventReceiver;

import zirk.events.LightSignalEvent;

public class SmartBulb extends DeviceSimulator {

	public SmartBulb() {
		super(DeviceType.SMART_BULB);
	}

	public static void main(String[] args) {
		SmartBulb smartBulbZirk = new SmartBulb();
		System.out.println("Running Smart Bulb Simulator");
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
        System.out.println("Subscribed to Smart Bulb events");
	}

}
