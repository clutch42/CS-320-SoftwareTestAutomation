//*********************************************************************
// File:        ContactTest.java
// Name:        Brian Engel
// Date:        8/4/2023
// Description: tests for validating Contact class works as intended
//*********************************************************************

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import module3milestone.Contact;

class ContactTest {
	// setup values for first, last, phone, and address
	String first = "Brian";
	String last = "Engel";
	String phone = "8328886076";
	String address = "2500 Woodland Park Dr. K304";
	
	@Test
	// test to make sure constructor works correctly including unique id
	void testContactConstructor() {
		// exercise
		Contact contact = new Contact(first, last, phone, address);
		Contact contact2 = new Contact(first, last, phone, address);
		// verify
		assertTrue(contact.getFirstName().equals(first));
		assertTrue(contact.getLastName().equals(last));
		assertTrue(contact.getPhone().equals(phone));
		assertTrue(contact.getAddress().equals(address));
		assertTrue(contact.getContactId().equals("1000000001"));
		assertTrue(contact2.getFirstName().equals(first));
		assertTrue(contact2.getLastName().equals(last));
		assertTrue(contact2.getPhone().equals(phone));
		assertTrue(contact2.getAddress().equals(address));
		assertTrue(contact2.getContactId().equals("1000000002"));
	}
	
	@Test
	// test to make sure null first name in setter throws exception
	void testFirstNameNotNull() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getFirstName().equals(first)); // verify first has value
		String nullFirst = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setFirstName(nullFirst);});	// test individual setter	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(nullFirst, last, phone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure long first name is setter throws exception
	void testFirstNameNotMoreThan10() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getFirstName().equals(first));	// verify first has value
		String longFirst = "BrianBrianBrian";
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setFirstName(longFirst);});	// test individual setter		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(longFirst, last, phone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure null last name in setter throws exception
	void testLastNameNotNull() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getLastName().equals(last));	// verify last has value
		String nullLast = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setLastName(nullLast);});	// test individual setter
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, nullLast, phone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure long last name in setter throws exception
	void testLastNameNotMoreThan10() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getLastName().equals(last));	// verify last has value
		String longLast = "EngelEngelEngel";
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setLastName(longLast);});	// test individual setter			
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, longLast, phone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure null phone in setter throws exception
	void testPhoneNotNull() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getPhone().equals(phone));	// verify phone has value
		String nullPhone = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setPhone(nullPhone);});	// test individual setter
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, last, nullPhone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure if phone does not have 10 characters in setter throws exception
	void testPhoneEqualTo10() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getPhone().equals(phone));	// verify phone has value
		String shortPhone = "12345678";
		String longPhone = "123456789012";
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setPhone(longPhone);});		// test individual setter	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, last, longPhone, address);});	// test constructor since it calls setter
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setPhone(shortPhone);});		// test individual setter	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, last, shortPhone, address);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure null address in setter throws exception
	void testAddressNotNull() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getAddress().equals(address));	// verify address has value
		String nullAddress = null;
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setAddress(nullAddress);});	// test individual setter
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, last, phone, nullAddress);});	// test constructor since it calls setter
	}
	
	@Test
	// test to make sure long address in setter throws exception
	void testAddressNotMoreThan30() {
		// setup
		Contact contact = new Contact(first, last, phone, address);
		assertTrue(contact.getAddress().equals(address));	// verify address has value
		String longAddress = "2500 Woodland Park Dr. K3042500 Woodland Park Dr. K304";
		// exercise and verify
		Assertions.assertThrows(IllegalArgumentException.class, () -> {contact.setAddress(longAddress);});	// test individual setter		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact(first, last, phone, longAddress);});	// test constructor since it calls setter
	}
}
