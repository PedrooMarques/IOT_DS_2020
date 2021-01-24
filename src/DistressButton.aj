import com.bezirk.middleware.addressing.ZirkEndPoint;

import handlers.alerts.AlertHandler;
import i18n.I18N;
import i18n.Messages;
import zirk.events.DeviceEvent;
import zirk.events.DistressButtonEvent;

public aspect DistressButton {

	pointcut distressButtonEventDetected(DeviceEvent event, ZirkEndPoint sender):
		call(void DeviceHandler.handleEvent(DeviceEvent, ZirkEndPoint)) && args(event, sender);

	void around(DeviceEvent event, ZirkEndPoint sender): distressButtonEventDetected(event, sender) {
        if (event instanceof DistressButtonEvent) {
        	String defaultMessage = "Distress Button pressed!";
        	String message = I18N.getString(Messages.DISTRESS_BUTTON_DETECTED, defaultMessage);
        	AlertHandler.getInstance().alert(message);
        }
	}

}
