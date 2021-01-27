import java.util.ArrayList;

import ui.input.Input;
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
				I18N.getString(Messages.ADD_MOTION_DETECTION_ALERT, "Add Motion Detection Alert"), 
				new Runnable() {
					@Override
					public void run() {
						// System.out.println(I18N.getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", Integer.toString(ContactHandler.getInstance().getContacts().getContactList().size())));
					}
				}));
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.REMOVE_MOTION_DETECTION_ALERT, "Remove Motion Detection Alert"), 
				new Runnable() {
					@Override
					public void run() {
						// System.out.println(I18N.getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", Integer.toString(ContactHandler.getInstance().getContacts().getContactList().size())));
					}
				}));
		proceed(newChoices);
	}

}
