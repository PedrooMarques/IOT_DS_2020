/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author G16
 *
 */
public class Contacts {
	
	class Contact {
		private String name;
		private int phoneNumber;
		
		public Contact(String name, int phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
	
	private ArrayList<Contact> contacts;
	private Contact emergencyContact;

	/**
	 * 
	 */
	public Contacts() {
		
	}

}
