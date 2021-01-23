/**
 * 
 */
package zirk.devices;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import zirk.events.LightSignalEvent;

/**
 * @author G16
 *
 */
public class SmartBulbZirk {

	private Bezirk bezirk;
	
	/**
	 * 
	 */
	public SmartBulbZirk() {
		BezirkMiddleware.initialize();
        bezirk = BezirkMiddleware.registerZirk("Smart Bulb Zirk");
        System.err.println("Got Bezirk instance");
        
        final EventSet lightSignalEvents = new EventSet(LightSignalEvent.class);
        
        lightSignalEvents.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof LightSignalEvent) {
                	System.err.println(((LightSignalEvent) event).getSignal());
                }
            }

        });
        bezirk.subscribe(lightSignalEvents);
	}

}
