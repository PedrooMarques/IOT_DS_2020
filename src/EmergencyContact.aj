import java.util.ArrayList;

import handlers.contacts.ContactHandler;
import handlers.contacts.Contact;
import ui.input.Input;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public aspect EmergencyContact {

	pointcut addEmergencyContactOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addEmergencyContactOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		String message = I18N.getString(Messages.SET_EMERGENCY_CONTACT, "Set Emergency Contact");
		Runnable task = new Runnable() {
			@Override
			public void run() {
				String name = "ABC";
				String phoneNumber = "912345678";
				System.out.println(I18N.getString(Messages.SETTING_EMERGENCY_CONTACT, "Setting Emergency Contact: {0} {1}", name, phoneNumber));
				ContactHandler.getInstance().getContacts().setEmergencyContact(new Contact(name, phoneNumber));
			}
		};
		MenuChoice choice = new MenuChoice(message, task);
		newChoices.add(choice);
		proceed(newChoices);
	}

}
