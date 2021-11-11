package com.bridgelabz.addressbooksystem;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Contact> contactList = new ArrayList<Contact>();

		Contact contact = new Contact();

		System.out.println("Enter the First Name : ");
		String firstName = sc.next();
		contact.setFirstName(firstName);

		System.out.println("Enter the Last Name : ");
		String lastName = sc.next();
		contact.setLastName(lastName);

		System.out.println("Enter the Address : ");
		String address = sc.next();
		contact.setAddress(address);

		System.out.println("Enter the City : ");
		String city = sc.next();
		contact.setCity(city);

		System.out.println("Enter the State : ");
		String state = sc.next();
		contact.setState(state);

		System.out.println("Enter the ZIP Code : ");
		long zipCode = sc.nextLong();
		contact.setZip(zipCode);

		System.out.println("Enter the Phone Number : ");
		long phoneNumber = sc.nextLong();
		contact.setPhoneNumber(phoneNumber);

		System.out.println("Enter the E-mail: ");
		String email = sc.next();
		contact.setEmail(email);

		contactList.add(contact);

		for (Contact c : contactList) {
			System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " "
					+ c.getState() + " " + c.getPhoneNumber() + " " + c.getZip() + " " + c.getEmail());
		}
	}
}