/**
 * 
 */
package helpers;

import com.bezirk.middleware.Bezirk;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import zirk.devices.MotionDetector;
import zirk.devices.SmartBulb;
import zirk.devices.Wearable;

/**
 * @author G16
 *
 */
public class BasicModule extends AbstractModule {
	
	private Bezirk bezirk;
	
	/**
	 * @param bezirk
	 */
	public BasicModule(Bezirk bezirk) {
		super();
		this.bezirk = bezirk;
	}

	@Override
	public void configure() {
		bind(Bezirk.class)
			.annotatedWith(Names.named("Bezirk"))
			.toInstance(this.bezirk);
		bind(MotionDetector.class)
			.annotatedWith(Names.named("MotionDetector"))
			.toInstance(new MotionDetector(bezirk));
		bind(SmartBulb.class)
			.annotatedWith(Names.named("SmartBulb"))
			.toInstance(new SmartBulb(bezirk));
		bind(Wearable.class)
			.annotatedWith(Names.named("Wearable"))
			.toInstance(new Wearable(bezirk));
	}

}
