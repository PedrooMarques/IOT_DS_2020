import java.util.ArrayList;

import ui.input.Input;
import ui.output.LightSignalType;
import ui.output.Output;
import handlers.devices.DeviceHandler;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;
import zirk.events.DeviceEvent;
import zirk.events.LightSignalEvent;

public aspect SmartBulbs {
	
	pointcut lightSignalEventDetected(DeviceEvent event):
		call(void DeviceHandler.sendEvent(DeviceEvent)) && args(event);
	
	void around(DeviceEvent event): lightSignalEventDetected(event) {
		proceed(event);
        if (event instanceof LightSignalEvent) {
        	System.err.println("Sending Light Signal event to Smart Bulb");
        }
	}

	void around(): execution(void Output.showWarning(..)) {
		proceed();
		System.err.println("**Sending Light Signal: Yellow**");
		LightSignalEvent event = new LightSignalEvent(LightSignalType.YELLOW);
		DeviceHandler.getInstance().sendEvent(event);
	}

	void around(): execution(void Output.showAlert(..)) {
		proceed();
		System.err.println("**Sending Light Signal: Red**");
		LightSignalEvent event = new LightSignalEvent(LightSignalType.RED);
		DeviceHandler.getInstance().sendEvent(event);
	}

	pointcut addLightCommandOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addLightCommandOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		String message = I18N.getString(Messages.TOGGLE_LIGHT);
		Runnable task = new Runnable() {
			@Override
			public void run() {
				Output.getInstance().showMessage(I18N.getString(Messages.TOGGLING_LIGHT));
				DeviceHandler.getInstance().sendEvent(new LightSignalEvent(LightSignalType.GREEN));
			}
		};
		MenuChoice choice = new MenuChoice(message, task);
		newChoices.add(choice);
		proceed(newChoices);
	}

}
