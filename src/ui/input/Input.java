package ui.input;

import java.util.ArrayList;

import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public class Input {

	private static Input instance;

	private Input() {

	}

	public static Input getInstance() {
		if (instance == null) {
			instance = new Input();
		}
		return instance;
	}

	public void renderMenu(ArrayList<MenuChoice> choices) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		while (option != choices.size()) {
			for (int i = 0; i < choices.size(); i++) { 
			    System.out.println((i + 1) + ". " + choices.get(i).getMessage());
			}
			System.out.println((choices.size() + 1) + ". Exit");
			System.out.println("-------------");
			System.out.println(I18N.getString(Messages.CHOOSE_OPTION, "Please choose an option"));
			option = scanner.nextInt();
			if (option < choices.size() + 1) {
				choices.get(option).run();
				continue;
			}
			if (option == choices.size() + 1) {
				System.exit(0);
			}
			System.out.println(I18N.getString(Messages.CHOICE_NOT_FOUND, "Please enter a valid option"));
		}
	}

}
