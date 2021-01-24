/**
 * 
 */
package handlers;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

import ui.output.LightSignals;
import zirk.events.LightSignalEvent;
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

        final LightSignalEvent lightSignalsEvent = new LightSignalEvent(signal);
        
        bezirk.sendEvent(lightSignalsEvent);
	}

	
	public static void main(String[] args) {
		new LightSignalsAssistantZirk(isto vem do user, nao vai ter main, certo?);
        System.err.println("This product has a Light Signals Assistant");
	}
	
}
