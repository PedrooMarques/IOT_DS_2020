/**
 * 
 */
package zirk.assistants;

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
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
    isto falta acabar de alterar
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
                    final MotionDetectionEvent mdDetection = (MotionDetectionEvent) event;
                    System.err.println("\nReceived air quality update: " + mdDetection.toString());
                  
                    //do something in response to this event
                    if (aqUpdate.getHumidity() > 0.7) {
                        System.out.println(I18N.getString(HUMIDITY_MSG));
                    }
                    if (aqUpdate.getDustLevel() > 20) {
                        System.out.println(I18N.getString(DUST_MSG));
                      }
                    if (aqUpdate.getPollenLevel() > 500) {
                        System.out.println(I18N.getString(POLLEN_MSG));
                     }
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
