/**
 * 
 */
package models.contacts;

import java.util.ArrayList;

/**
 * @author G16
 *
 */
public class Contacts {

	private ArrayList<Contact> contacts;
	private Contact emergencyContact;

	/**
	 * 
	 */
	public Contacts() {
		this.contacts = new ArrayList<Contact>();
	}

	public ArrayList<Contact> getContacts() {
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
