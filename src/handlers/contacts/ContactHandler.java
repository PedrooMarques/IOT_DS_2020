package handlers.contacts;

public class ContactHandler {

	private Contacts contacts;

	private ContactHandler() {
		
	}

	public static ContactHandler getInstance() {
		if (instance == null) {
			instance = new ContactHandler();
		}
		return instance;
	}

	public Contacts getContacts() {
		return this.contacts;
	}

}
