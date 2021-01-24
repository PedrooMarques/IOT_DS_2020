package zirk.devices;

import com.bezirk.middleware.Bezirk;

public abstract class Device {

	protected final Bezirk bezirk;

	public Device(Bezirk bezirk) {
		this.bezirk = bezirk;
	}

}
