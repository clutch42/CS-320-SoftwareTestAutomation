//*********************************************************************
// File:        ContactServiceTest.java
// Name:        Brian Engel
// Date:        8/4/2023
// Description: tests for validating ContactService class works as intended
//*********************************************************************

package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import module3milestone.Contact;
import module3milestone.ContactService;

class ContactServiceTest {
	// setup values for first, last, phone, and address and create a contact list
	ContactService contactList = new ContactService();
	String firstName = "Brian";
	String lastName = "Engel";
	String phone = "8328886076";
	String address = "2500 Woodland Park Dr. K304";
	
	@Test
	// test addContact to ensure it adds to empty list as well as list with list with contact
	void testAddContact() {
		// setup
		contactList.erase();	// ensure contact list is empty
		// exercise and verify
		contactList.addContact(firstName, lastName, phone, address);	// add to empty list and check values
		assertEquals(firstName,contactList.getContactAtIndex(0).getFirstName());
		assertEquals(lastName,contactList.getContactAtIndex(0).getLastName());
		assertEquals(phone,contactList.getContactAtIndex(0).getPhone());
		assertEquals(address, contactList.getContactAtIndex(0).getAddress());
		contactList.addContact(firstName, lastName, phone, address);	// add to list with contact and check values
		assertEquals(firstName,contactList.getContactAtIndex(1).getFirstName());
		assertEquals(lastName,contactList.getContactAtIndex(1).getLastName());
		assertEquals(phone,contactList.getContactAtIndex(1).getPhone());
		assertEquals(address, contactList.getContactAtIndex(1).getAddress());		
	}
	
	@Test
	// test for adding invalid first name throws exception
	void testAddInvalidFirstName() {
		// setup
		String tooLongFirstName = "123456789012";
		String nullFirstName = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(tooLongFirstName, lastName, phone, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(nullFirstName, lastName, phone, address);});
	}
	
	@Test
	// test for adding invalid last name throws exception
	void testAddInvalidLastName() {
		// setup
		String tooLongLastName = "123456789012";
		String nullLastName = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, tooLongLastName, phone, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, nullLastName, phone, address);});
	}
	
	@Test
	// test for adding invalid phone throws exception
	void testAddInvalidPhone() {
		// setup
		String tooLongPhone = "123456789012";
		String tooShortPhone = "12345";
		String nullPhone = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, lastName, tooLongPhone, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, lastName, tooShortPhone, address);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, lastName, nullPhone, address);});
	}
	
	@Test
	// test for adding invalid address throws exception
	void testAddInvalidAddress() {
		// setup
		String tooLongAddress = "1234567890123456789012345678901234567890";
		String nullAddress = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, lastName, phone, tooLongAddress);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.addContact(firstName, lastName, phone, nullAddress);});
	}
	
	@Test
	// test to ensure deleting a contact works when id is found and throws exception when id is not found
	void testDeleteContact() {
		// setup
		Contact testContact = new Contact(firstName, lastName, phone, address);	// create valid contact
		// add this contact to arraylist. since the constructor creates a new id every time the one added will have a id 1 higher
		contactList.addContact(testContact.getFirstName(), testContact.getLastName(), testContact.getPhone(), testContact.getAddress());
		String contactNumber = testContact.getContactId();	// id number of testContact
		// turn contactNumber into integer, add 1, and turn it back to a string
		String contactInArrayId = Integer.toString(Integer.parseInt(contactNumber)+1);
		// exercise and verify
		// throws exception because id is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.deleteContact(null);});
		// throws exception because id is not in arraylist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.deleteContact(contactInArrayId+"1");});
		// deletes contact with contactInArrayId
		contactList.deleteContact(contactInArrayId);
		// throws exception now because contactInArrayId is not in array anymore
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.deleteContact(contactInArrayId);});
		// still throws exception because id is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.deleteContact(null);});
		// still throws exception because id is not in arraylist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.deleteContact(contactInArrayId+"1");});
	}
	
	@Test
	// test ensures update contact updates everything unless an invalid argument is passed and then throws an exception 
	void testUpdateContact() {
		// setup
		// make sure there is a contact to update
		if (contactList.getArraySize() == 0) {
			contactList.addContact(firstName, lastName, phone, address);
		}
		String newFirst = "John";
		String newLast = "Doe";
		String newPhone = "1234567890";
		String newAddress = "123 Some Street";
		String invalidFirst = null;
		String invalidLast = "123456789012";
		String invalidPhone = null;
		String invalidAddress = "1234567890123456789012345678901234567890";
		// get id of first element in the arraylist to update
		String temp = contactList.getContactAtIndex(0).getContactId();
		// exercise and verify
		contactList.updateContact(temp, newFirst, newLast, newPhone, newAddress);
		assertEquals(contactList.getContactAtIndex(0).getFirstName(), newFirst);
		assertEquals(contactList.getContactAtIndex(0).getLastName(), newLast);
		assertEquals(contactList.getContactAtIndex(0).getPhone(), newPhone);
		assertEquals(contactList.getContactAtIndex(0).getAddress(), newAddress);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.updateContact(temp + "1", newFirst, newLast, newPhone, newAddress);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.updateContact(temp, invalidFirst, newLast, newPhone, newAddress);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.updateContact(temp, newFirst, invalidLast, newPhone, newAddress);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.updateContact(temp, newFirst, newLast, invalidPhone, newAddress);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contactList.updateContact(temp, newFirst, newLast, newPhone, invalidAddress);});
	}
}
