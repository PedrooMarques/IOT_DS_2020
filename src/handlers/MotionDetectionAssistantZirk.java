/**
 * 
 */
package handlers;

import static i18n.Messages.DUST_MSG;
import static i18n.Messages.HUMIDITY_MSG;
import static i18n.Messages.POLLEN_MSG;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.bezirk.middleware.messages.Event;
import com.bezirk.middleware.messages.EventSet;

import i18n.I18N;
import zirk.events.MotionDetectionEvent;

/**
 * @author G16
 *
 */
public class MotionDetectionAssistantZirk {

	/**
	 * 
	 */
	public MotionDetectionAssistantZirk() {
		BezirkMiddleware.initialize();
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Motion Detection Assistant Zirk");
        System.err.println("Got Bezirk instance");

        final EventSet motionDetectionEvents = new EventSet(MotionDetectionEvent.class);
        
        motionDetectionEvents.setEventReceiver(new EventSet.EventReceiver() {
            @Override
            public void receiveEvent(Event event, ZirkEndPoint sender) {
                //Check if this event is of interest
                if (event instanceof MotionDetectionEvent) {
                	aspeto
                }
            }

        });
        bezirk.subscribe(motionDetectionEvents);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MotionDetectionAssistantZirk();
        System.err.println("This product has a Motion Detection Assistant");
	}

}
