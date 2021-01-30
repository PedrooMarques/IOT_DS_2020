import java.util.ArrayList;

import handlers.alerts.Alert;
import handlers.alerts.AlertHandler;
import handlers.alerts.InactivityAlert;
import handlers.alerts.MotionDetectionAlert;
import ui.input.Input;
import ui.output.Output;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public aspect Alerts {

	pointcut addListAlertsOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addListAlertsOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.LIST_ALERTS), 
				new Runnable() {
					@Override
					public void run() {
						ArrayList<Alert> alerts = AlertHandler.getInstance().getAlerts().list();
        				for (int i = 0; i < alerts.size(); i++) {
        					if (alerts.get(i) instanceof MotionDetectionAlert) {
        						MotionDetectionAlert alert = (MotionDetectionAlert)alerts.get(i);
        						Output.getInstance().showMessage(I18N.getString(Messages.SHOW_MOTION_DETECTION_ALERT, Integer.toString(i + 1), alert.getLocation()));
        					}
        					if (alerts.get(i) instanceof InactivityAlert) {
        						InactivityAlert alert = (InactivityAlert)alerts.get(i);
        						Output.getInstance().showMessage(I18N.getString(Messages.SHOW_INACTIVITY_ALERT, Integer.toString(i + 1), Integer.toString(alert.getDurationMinutes())));
        					}
        				}
					}
				}));
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.REMOVE_ALERT), 
				new Runnable() {
					@Override
					public void run() {
						Alert alert = AlertHandler.getInstance().getAlerts().list().get(0);
						Output.getInstance().showMessage(I18N.getString(Messages.REMOVING_ALERT, alert.getAlertType().toString()));
						AlertHandler.getInstance().getAlerts().remove(alert);
					}
				}));
		proceed(newChoices);
	}

}
