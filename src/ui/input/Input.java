package ui.input;

import java.util.ArrayList;
import java.util.Scanner;

import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public class Input {

	private static final Input INSTANCE = new Input();

	private Input() {

	}

	public static Input getInstance() {
		return INSTANCE;
	}

	public void renderMenu(ArrayList<MenuChoice> choices) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		while (option != choices.size()) {
			System.out.println();
			for (int i = 0; i < choices.size(); i++) { 
			    System.out.println((i + 1) + ". " + choices.get(i).getMessage());
			}
			System.out.println((choices.size() + 1) + ". Exit");
			System.out.println("-------------");
			System.out.println(I18N.getString(Messages.CHOOSE_OPTION));
			option = scanner.nextInt();
			if (option < choices.size() + 1) {
				choices.get(option - 1).run();
				continue;
			}
			if (option == choices.size() + 1) {
				System.exit(0);
			}
			System.out.println(I18N.getString(Messages.CHOICE_NOT_FOUND));
		}
		scanner.close();
	}

}
