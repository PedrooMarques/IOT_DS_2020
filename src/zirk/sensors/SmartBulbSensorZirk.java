/**
 * 
 */
package zirk.sensors;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import zirk.events.LightSignalsEvent;

/**
 * @author G16
 *
 */
public class SmartBulbSensorZirk {

	private Bezirk bezirk;
	
	/**
	 * 
	 */
	public SmartBulbSensorZirk() {
		BezirkMiddleware.initialize();
        bezirk = BezirkMiddleware.registerZirk("Smart Bulb Zirk");
        System.err.println("Got Bezirk instance");
        
        final EventSet lightSignalEvents = new EventSet(LightSignalsEvent.class);
        
        lightSignalEvents.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof LightSignalsEvent) {
                	System.err.println(((LightSignalsEvent) event).getSignal());
                }
            }

        });
        bezirk.subscribe(lightSignalEvents);
	}

}
