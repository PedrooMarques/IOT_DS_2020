package zirk.devices;

import com.bezirk.middleware.Bezirk;

import devices.DeviceType;

public abstract class Device {

	protected final Bezirk bezirk;
	protected final DeviceType deviceType;

	public Device(Bezirk bezirk, DeviceType deviceType) {
		this.bezirk = bezirk;
		this.deviceType = deviceType;
	}

}
