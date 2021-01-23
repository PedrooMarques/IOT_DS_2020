/**
 * 
 */
package zirk.assistants;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import models.LightSignals;
import zirk.events.LightSignalsEvent;

/**
 * @author G16
 *
 */
public class LightSignalsAssistantZirk {

	/**
	 * 
	 */
	public LightSignalsAssistantZirk(LightSignals signal) {
		BezirkMiddleware.initialize();
        final Bezirk bezirk = BezirkMiddleware.registerZirk("Light Signals Assistant Zirk");
        System.err.println("Got Bezirk instance");

        final LightSignalsEvent lightSignalsEvent = new LightSignalsEvent(signal);
        
        bezirk.sendEvent(lightSignalsEvent);
	}

	
	public static void main(String[] args) {
		new LightSignalsAssistantZirk(isto vem do user, nao vai ter main, certo?);
        System.err.println("This product has a Light Signals Assistant");
	}
	
}
