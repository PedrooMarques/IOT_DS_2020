package startup;

import java.util.ArrayList;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.google.inject.Guice;
import com.google.inject.Injector;

import persistence.BasicModule;
import ui.input.Input;
import helpers.MenuChoice;
import i18n.I18N;
import i18n.Messages;

public class Startup {

	private static final String zirkName = "Main Application";

	public static void main(String[] args) {
		BezirkMiddleware.initialize();
        Bezirk bezirk = BezirkMiddleware.registerZirk(zirkName);
        
        ArrayList<MenuChoice> choices = new ArrayList<MenuChoice>();
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_CONTACT, "Add Contact"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_CONTACT, "Remove Contact"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.SET_EMERGENCY_CONTACT, "Set Emergency Contact"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_WARNING, "Add Warning"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_WARNING, "Remove Warning"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_MOTION_DETECTION_ALERT, "Add Motion Detection Alert"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_MOTION_DETECTION_ALERT, "Remove Motion Detection Alert"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.ADD_INACTIVITY_ALERT, "Add Inactivity Alert"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        choices.add(new MenuChoice(
        		I18N.getString(Messages.REMOVE_INACTIVITY_ALERT, "Remove Inactivity Alert"),
        		new Runnable() {
        			@Override
        			public void run() {
        				
        			}
        		}));
        Input.getInstance().renderMenu(choices);
        
        BasicModule basicModule = new BasicModule(bezirk);
		Injector injector = Guice.createInjector(basicModule);
	}

}
