import java.util.ArrayList;

import ui.input.Input;
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
				I18N.getString(Messages.ADD_INACTIVITY_ALERT, "Add Inactivity Alert"), 
				new Runnable() {
					@Override
					public void run() {
						// System.out.println(I18N.getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", Integer.toString(ContactHandler.getInstance().getContacts().getContactList().size())));
					}
				}));
		newChoices.add(new MenuChoice(
				I18N.getString(Messages.REMOVE_INACTIVITY_ALERT, "Remove Inactivity Alert"), 
				new Runnable() {
					@Override
					public void run() {
						// System.out.println(I18N.getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", Integer.toString(ContactHandler.getInstance().getContacts().getContactList().size())));
					}
				}));
		proceed(newChoices);
	}

}