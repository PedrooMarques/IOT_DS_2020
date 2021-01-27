import java.util.ArrayList;

import ui.input.Input;
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
		String message = I18N.getString(Messages.LIST_ALERTS, "List Alerts");
		Runnable task = new Runnable() {
			@Override
			public void run() {
				// System.out.println(I18N.getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", Integer.toString(ContactHandler.getInstance().getContacts().getContactList().size())));
			}
		};
		MenuChoice choice = new MenuChoice(message, task);
		newChoices.add(choice);
		proceed(newChoices);
	}

}
