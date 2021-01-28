import java.util.ArrayList;

import handlers.alerts.AlertHandler;
import handlers.alerts.MotionDetectionAlert;
import ui.input.Input;
import ui.output.Output;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public aspect MotionDetection {

	pointcut addMotionDetectionOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addMotionDetectionOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.ADD_MOTION_DETECTION_ALERT), 
				new Runnable() {
					@Override
					public void run() {
						String location = "Cozinha";
						Output.getInstance().showMessage(I18N.getString(Messages.ADDING_MOTION_DETECTION_ALERT, location));
						AlertHandler.getInstance().getAlerts().add(new MotionDetectionAlert(location));
					}
				}));
		proceed(newChoices);
	}

}
