import java.util.ArrayList;

import handlers.contacts.ContactHandler;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public aspect VoiceCommands {

	pointcut addVoiceCommandOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addVoiceCommandOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		String message = I18N.getInstance().getString(Messages.VOICE_COMMAND, "**Voice Command**");
		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("**Executing Voice Command**");
				System.out.println(I18N.getInstance().getString(Messages.CONTACT_LIST_SIZE, "Number of contacts: {0}", ContactHandler.getInstance().getContacts().getContactList().size());
			}
		}
		MenuChoice choice = new MenuChoice(message, task);
		newChoices.add(choice);
		proceed(newChoices);
	}

}
