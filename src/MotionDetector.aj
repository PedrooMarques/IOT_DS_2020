import com.google.inject.Guice;
import com.google.inject.Injector;

import handlers.devices.DeviceHandler;
import persistence.BasicModule;

public aspect MotionDetector {
	
	after(DeviceHandler handler) :
		execution(DeviceHandler getInstance()) && args(handler){
			BasicModule basicModule = new BasicModule();
			Injector injector = Guice.createInjector(basicModule);
			injector.setMotionDetector
	}

}