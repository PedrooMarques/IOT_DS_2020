/**
 * 
 */
package persistence;

import com.bezirk.middleware.core.device.Device;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import zirk.devices.MotionDetector;

/**
 * @author G16
 *
 */
public class BasicModule extends AbstractModule {
	
	private MotionDetector asdasd;

	@Override
	public void configure() {
		
		bind(MotionDetector.class)
			.annotatedWith(Names.named("MotionDetector"))
			.toInstance(new MotionDetector(null));
		
		bind(Device.class)
		.annotatedWith(Names.named("SmartBulb"))
		.to();
		
		bind(Device.class)
		.annotatedWith(Names.named("Wearable"))
		.to();
	}
	
	setMotiondetector(MotionDetector motionDetector) {
		
	}

}
