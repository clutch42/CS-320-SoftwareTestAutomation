//*********************************************************************
// File:        Contact.java
// Name:        Brian Engel
// Date:        8/4/2023
// Description: class: Contact
//				variables: idCounter, object variables
//				functions: constructor, setter for first, last, phone and address, 
//					getter for id, first, last, phone, and address
//*********************************************************************

package module3milestone;

public class Contact {
	
	private static int idCounter = 1000000000;	// variable to keep track of a counter to ensure each object has a different id
	private	String contactId;	
	private	String firstName;
	private	String lastName;
	private	String phone;
	private	String address;
	
	// constructor with argument for first, last, phone, and address
	public Contact(String first, String last, String newPhone, String newAddress) throws IllegalArgumentException {
		++idCounter;	// increase idCounter
		String counter = Integer.toString(idCounter);	// turn idCounter to string
		if (counter == null || counter.length() > 10) {	// if counter is null (impossible but a requirement) or counter has more than 10 characters
			throw new IllegalArgumentException("Invalid Contact Id"); // throw exception
		}
		this.contactId = counter; 	// set object id
		setFirstName(first);		// set first
		setLastName(last);			// set last
		setPhone(newPhone);			// set phone
		setAddress(newAddress);		// set address
	}
	
	// sets first name on object with argument for first 
	public void setFirstName(String first) throws IllegalArgumentException {
		if (first == null || first.length() > 10) {	// if first is null or has more than 10 characters
			throw new IllegalArgumentException("Invalid First Name"); // throw exception
		}
		this.firstName = first; // set object first
	}
	
	// sets last name on object with argument for last
	public void setLastName(String last) throws IllegalArgumentException {
		if (last == null || last.length() > 10) {	// if last is null or has more than 10 characters
			throw new IllegalArgumentException("Invalid Last Name");	// throw exception
		}
		this.lastName = last;	// set object last
	}
	
	// sets phone on object with argument for phone
	public void setPhone(String newPhone) throws IllegalArgumentException {
		if (newPhone == null || newPhone.length() != 10) {	// if phone is null or does not have 10 characters
			throw new IllegalArgumentException("Invalid Phone Number");	// throw exception
		}
		this.phone = newPhone;	// set object phone
	}
	
	// sets address on object with argument for address
	public void setAddress(String newAddress) throws IllegalArgumentException {
		if (newAddress == null || newAddress.length() > 30) {	// if address is null or has more than 30 characters
			throw new IllegalArgumentException("Invalid Address");	// throws exception
		}
		this.address = newAddress; // set object address
	}
	
	// gets object id
	public String getContactId() {
		return this.contactId;	// return object id
	}
	
	// gets object first
	public String getFirstName() {
		return this.firstName;	// return object first
	}
	
	// gets object last
	public String getLastName() {
		return this.lastName;	// return object last
	}
	
	// gets object phone
	public String getPhone() {
		return this.phone;	// return object phone
	}
	
	// gets object address
	public String getAddress() {
		return this.address;	// return object address
	}
}

