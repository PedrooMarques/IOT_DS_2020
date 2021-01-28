import java.util.ArrayList;

import handlers.contacts.ContactHandler;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;
import ui.input.Input;
import ui.output.Output;

public aspect VoiceCommands {

	pointcut addVoiceCommandOption(ArrayList<MenuChoice> choices):
		execution(void Input.renderMenu(ArrayList<MenuChoice>)) && args(choices);

	void around(ArrayList<MenuChoice> choices): addVoiceCommandOption(choices) {
		ArrayList<MenuChoice> newChoices = new ArrayList<MenuChoice>();
		for (MenuChoice c: choices) {
			newChoices.add(c);
		}
		String message = "**Voice Command**";
		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.err.println("**Executing Voice Command**");
				Output.getInstance().showMessage(I18N.getString(Messages.CONTACT_LIST_SIZE, Integer.toString(ContactHandler.getInstance().getContacts().list().size())));
			}
		};
		MenuChoice choice = new MenuChoice(message, task);
		newChoices.add(choice);
		proceed(newChoices);
	}

}
