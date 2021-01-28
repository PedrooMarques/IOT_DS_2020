package startup;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.google.inject.Guice;
import com.google.inject.Injector;

import handlers.contacts.Contact;
import handlers.contacts.ContactHandler;
import handlers.warnings.Frequency;
import handlers.warnings.Warning;
import handlers.warnings.WarningHandler;
import ui.input.Input;
import ui.output.Output;
import helpers.BasicModule;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public class Startup {

	private static final String ZIRK_NAME = "Main Application";

	public Startup() {
		BezirkMiddleware.initialize();
        Bezirk bezirk = BezirkMiddleware.registerZirk(ZIRK_NAME);
        
        ArrayList<MenuChoice> choices = new ArrayList<MenuChoice>();
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_CONTACT),
        		new Runnable() {
        			@Override
        			public void run() {
        				String name = "ABC";
        				String phoneNumber = "912345678";
        				Output.getInstance().showMessage(I18N.getString(Messages.ADDING_CONTACT, name, phoneNumber));
        				ContactHandler.getInstance().getContacts().add(new Contact(name, phoneNumber));
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_CONTACT),
        		new Runnable() {
        			@Override
        			public void run() {
        				Contact contact = ContactHandler.getInstance().getContacts().list().get(0);
        				Output.getInstance().showMessage(I18N.getString(Messages.REMOVING_CONTACT, contact.getName(), contact.getPhoneNumber()));
        				ContactHandler.getInstance().getContacts().remove(contact);
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.LIST_CONTACTS),
        		new Runnable() {
        			@Override
        			public void run() {
        				ArrayList<Contact> contacts = ContactHandler.getInstance().getContacts().list();
        				for (int i = 0; i < contacts.size(); i++) {
        					Output.getInstance().showMessage(I18N.getString(Messages.SHOW_CONTACT, Integer.toString(i + 1), contacts.get(i).getName(), contacts.get(i).getPhoneNumber()));
        				}
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_WARNING),
        		new Runnable() {
        			@Override
        			public void run() {
        				String name = "Warning1";
        				LocalDateTime startDate = LocalDateTime.of(2021, Month.JANUARY, 0, 0, 0, 0);
        				LocalDateTime endDate = LocalDateTime.of(2021, Month.JANUARY, 0, 0, 0, 0);
        				Frequency frequency = Frequency.MINUTE;
        				int frequencyNumber = 1;
        				Output.getInstance().showMessage(I18N.getString(Messages.ADDING_WARNING, name, startDate.format(DateTimeFormatter.ISO_DATE_TIME), endDate.format(DateTimeFormatter.ISO_DATE_TIME), frequency.toString(), Integer.toString(frequencyNumber)));
        				WarningHandler.getInstance().getWarnings().add(new Warning(name, startDate, endDate, frequency, frequencyNumber));
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_WARNING),
        		new Runnable() {
        			@Override
        			public void run() {
        				Warning warning = WarningHandler.getInstance().getWarnings().list().get(0);
        				Output.getInstance().showMessage(I18N.getString(Messages.REMOVING_WARNING, warning.getName(), warning.getStartDate().format(DateTimeFormatter.ISO_DATE_TIME), warning.getEndDate().format(DateTimeFormatter.ISO_DATE_TIME), warning.getFrequency().toString(), Integer.toString(warning.getFrequencyNumber())));
        				WarningHandler.getInstance().getWarnings().remove(warning);
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.LIST_WARNINGS),
        		new Runnable() {
        			@Override
        			public void run() {
        				ArrayList<Warning> warnings = WarningHandler.getInstance().getWarnings().list();
        				for (int i = 0; i < warnings.size(); i++) {
        					Output.getInstance().showMessage(I18N.getString(Messages.SHOW_WARNING, Integer.toString(i + 1), warnings.get(i).getName(), warnings.get(i).getStartDate().format(DateTimeFormatter.ISO_DATE_TIME), warnings.get(i).getEndDate().format(DateTimeFormatter.ISO_DATE_TIME), warnings.get(i).getFrequency().toString(), Integer.toString(warnings.get(i).getFrequencyNumber())));
        				}
        			}
        		}));
        Input.getInstance().renderMenu(choices);
        
        BasicModule basicModule = new BasicModule(bezirk);
		Injector injector = Guice.createInjector(basicModule);
	}

}
