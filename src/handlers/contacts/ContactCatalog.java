package handlers.contacts;

import java.util.ArrayList;

/**
 * @author G16
 *
 */
public class ContactCatalog {

	private ArrayList<Contact> contacts;
	private Contact emergencyContact;

	/**
	 * 
	 */
	public ContactCatalog() {
		this.contacts = new ArrayList<Contact>();
	}

	public ArrayList<Contact> getContactList() {
		return this.contacts;
	}

	public Contact addContact(Contact contact) {
		this.contacts.add(contact);
		return contact;
	}

	public Contact removeContact(Contact contact) {
		this.contacts.remove(contact);
		return contact;
	}

	public Contact getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(Contact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

}
