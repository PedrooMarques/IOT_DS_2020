package handlers.contacts;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import handlers.ICatalog;
import helpers.PersistanceManager;

/**
 * @author G16
 *
 */
public class ContactCatalog implements ICatalog<Contact> {

	private ArrayList<Contact> contacts;
	private Contact emergencyContact;
	private PersistanceManager<ContactPersistence> persistenceManager;

	public ContactCatalog() {
		this.contacts = new ArrayList<Contact>();
		this.emergencyContact = null;
		this.persistenceManager = new PersistanceManager<ContactPersistence>("contacts.db");
		try {
			ContactPersistence persistence = this.persistenceManager.read();
			this.contacts = persistence.contacts;
			this.emergencyContact = persistence.emergencyContact;
		} catch (IOException | ClassNotFoundException e) {}
	}

	public ArrayList<Contact> list() {
		return this.contacts;
	}

	public Contact add(Contact contact) {
		this.contacts.add(contact);
		try {
			ContactPersistence persistence = new ContactPersistence(this.contacts, this.emergencyContact);
			this.persistenceManager.write(persistence);
		} catch (IOException e) {}
		return contact;
	}

	public Contact remove(Contact contact) {
		this.contacts.remove(contact);
		try {
			ContactPersistence persistence = new ContactPersistence(this.contacts, this.emergencyContact);
			this.persistenceManager.write(persistence);
		} catch (IOException e) {}
		return contact;
	}

	public Contact getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(Contact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public class ContactPersistence implements Serializable {

		private static final long serialVersionUID = 1L;
		public ArrayList<Contact> contacts;
		public Contact emergencyContact;
		
		public ContactPersistence(ArrayList<Contact> contacts, Contact emergencyContact) {
			this.contacts = contacts;
			this.emergencyContact = emergencyContact;
		}

	}

}
