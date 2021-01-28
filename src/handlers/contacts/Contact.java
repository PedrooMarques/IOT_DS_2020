package handlers.contacts;

import java.io.Serializable;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNumber;
	
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	protected void sendSMS(String message) {
		System.err.println("**SMS Sent**");
	}

}
