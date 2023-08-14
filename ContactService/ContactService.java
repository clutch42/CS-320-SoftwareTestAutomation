//*********************************************************************
// File:        ContactService.java
// Name:        Brian Engel
// Date:        8/4/2023
// Description: class: ContactService
// 				variables: contacts array list
//				functions: addContact, deleteContact, updateContact, getContactIndex, 
//						getContactAtIndex, getArraySize, erase
//*********************************************************************

package module3milestone;
import java.util.ArrayList;

public class ContactService {
	private ArrayList<Contact> contacts = new ArrayList<Contact>();	// arraylist of contacts for each instance of ContactService
	
	// constructor
	public ContactService() {}
	
	// add a contact to arraylist with arguments first, last, phone, and address
	public void addContact(String first, String last, String phone, String address) throws IllegalArgumentException {
		// call constructor for Contact. if any of the arguments are invalid they will throw exceptions in the setters in Contact
		Contact tempContact = new Contact(first, last, phone, address);
		contacts.add(tempContact); // add contact to arraylist
	}
	
	// delete a contact from arraylist with argument id
	public void deleteContact(String id) throws IllegalArgumentException {
		// calls helper function to get index of the id. if not found throws exception
		int index = getContactIndex(id);
		contacts.remove(index);	// remove contact at index
	}
	
	// update a contact form arraylist with arguments id, first, last, phone, and address
	public void updateContact(String id, String first, String last, String phone, String address) throws IllegalArgumentException {
		// calls helper function to get index of the id. if not found throws exception
		int index = getContactIndex(id);
		// if any of the arguments passed are invalid the setter functions in Contact will throw exceptions
		contacts.get(index).setFirstName(first);	// update first 
		contacts.get(index).setLastName(last);		// update last
		contacts.get(index).setPhone(phone);		// update phone
		contacts.get(index).setAddress(address);	// update address
	}
	
	// helper function to find the index of an id
	public int getContactIndex(String id) throws IllegalArgumentException {
		int index = -1;	// returns -1 if id not found
		for (int i = 0; i < contacts.size(); i++) {	// search through all contacts
			if (contacts.get(i).getContactId().equals(id)) {	// if id equals the id at this index in contacts arraylist
				index = i;	// index is i
				break;	// exit out of loop since id is found
			}
		}
		if (index == -1) { // throw exception since id is not found
			throw new IllegalArgumentException("Contact Id not found");
		}
		return index; // return index or -1
	}
	
	// helper function for testing
	// gets the contact at certain index since arraylist is private for encapsulation
	public Contact getContactAtIndex(int index) {
	    return contacts.get(index);
	}
	
	// helper function for testing
	// gets arraylist size since arraylist is private for encapsulation
	public int getArraySize( ) {
		return contacts.size();
	}
	
	// helper function for testing
	// erases arraylist since arraylist is private for encapsulation
	public void erase() {
		contacts.clear();
	}
}
