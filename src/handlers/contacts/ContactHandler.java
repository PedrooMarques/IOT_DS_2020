package handlers.contacts;

public class ContactHandler {

	private static final ContactHandler INSTANCE = new ContactHandler();
	private ContactCatalog contacts;

	private ContactHandler() {
		this.contacts = new ContactCatalog();
	}

	public static ContactHandler getInstance() {
		return INSTANCE;
	}

	public ContactCatalog getContacts() {
		return this.contacts;
	}

	public void sendSMS(String message, Contact contact) {
		contact.sendSMS(message);
	}

	public void sendEmergencySMS(String message) {
		Contact emergencyContact = contacts.getEmergencyContact();
		if (emergencyContact != null) {
			this.sendSMS(message, emergencyContact);
		}
	}

}
