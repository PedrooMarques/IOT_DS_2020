package devices;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public abstract class DeviceSimulator {
	
	protected final Bezirk bezirk;

	public DeviceSimulator(String deviceType) {
		BezirkMiddleware.initialize();
        this.bezirk = BezirkMiddleware.registerZirk(deviceType);
	}

}
