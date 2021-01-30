import java.util.ArrayList;

import handlers.alerts.AlertHandler;
import handlers.alerts.InactivityAlert;
import ui.input.Input;
import ui.output.Output;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public aspect Inactivity {

	pointcut addInactivityOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addInactivityOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.ADD_INACTIVITY_ALERT), 
				new Runnable() {
					@Override
					public void run() {
						int durationMinutes = 1;
						Output.getInstance().showMessage(I18N.getString(Messages.ADDING_INACTIVITY_ALERT, Integer.toString(durationMinutes)));
						AlertHandler.getInstance().getAlerts().add(new InactivityAlert(durationMinutes));
					}
				}));
		proceed(newChoices);
	}

}
