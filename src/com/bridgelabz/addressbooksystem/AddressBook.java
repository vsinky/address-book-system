package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNumber;
	String email;
	Scanner sc = new Scanner(System.in);
	private List<Contact> contactList = new ArrayList<Contact>();

	Contact contact = new Contact();
	boolean flag = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook ab = new AddressBook();
		int option = 1;
		do {

			System.out.println("Enter 1 to add contact \nEnter 2 to edit \nEnter 3 to delete \nEnter 4 to print \nEnter 5 to exits");
			System.out.println("Enter the option : ");
			option = sc.nextInt();
			switch (option) {
			case 1:

				ab.addContact();

				break;

			case 2:
				ab.updateContact();

				break;

			case 3:
				ab.deleteContact();

				break;
				
			case 4:
				ab.displayContact();
				
				break;
				
			case 5:
				System.out.println("Thank you");
				System.exit(0);

			default:
				System.out.println("Invalid Option");
			}
		} while (option < 5 || option > 0);
	}


	private void displayContact() {	
			System.out.println("Print");
			int i = 1;
			for (Contact c : contactList) {
				System.out.println(
						"Contact." + i + " [ FirstName=" + c.getFirstName() + ", FastName=" + c.getLastName() + ", Address="
								+ c.getAddress() + ", city=" + c.getCity() + ", state=" + c.getState() + ", zip-code="
								+ c.getZip() + ", Phone Number=" + c.getPhoneNumber() + ", email=" + c.getEmail() + "]");
				i++;
			}
		}
				
			
			

	private void deleteContact() {
		System.out.println("Delete");
		System.out.println("Enter the first name : ");
		String deleteName = sc.next();
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getFirstName().equals(deleteName)) {
				contactList.remove(i);
			}

		}
	}
	
	

	public void updateContact() {
		
		System.out.println("Edit");
		System.out.println("Enter the first Name : ");
		String name = sc.next();
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getFirstName().equals(name)) {
				System.out.println("Enter the Last Name : ");
				String newLastName = sc.next();
				contact.setLastName(newLastName);

				System.out.println("Enter the Address : ");
				String newAddress = sc.next();
				contact.setAddress(newAddress);

				System.out.println("Enter the City : ");
				String newCity = sc.next();
				contact.setCity(newCity);

				System.out.println("Enter the State : ");
				String newState = sc.next();
				contact.setState(newState);

				System.out.println("Enter the ZIP Code : ");
				long newZipCode = sc.nextLong();
				contact.setZip(newZipCode);

				System.out.println("Enter the Phone Number : ");
				long newPhoneNumber = sc.nextLong();
				contact.setPhoneNumber(newPhoneNumber);

				System.out.println("Enter the E-mail: ");
				String newEmail = sc.next();
				contact.setEmail(newEmail);
				
				contactList.add(contact);
						}
	
			}
		}
	

	private void addContact() {
		contactList.add(contact);
		System.out.println("Add");
		System.out.println("Enter the First Name : ");
		String firstName = sc.next();
		if (getIndex(firstName)==-1) {
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
		//contactList.add(Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
		}else {
			System.out.println("");
		}
		
		
			
		

//		for (Contact c : contactList) {
//			System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " "
//					+ c.getState() + " " + c.getPhoneNumber() + " " + c.getZip() + " " + c.getEmail());
//		}

	}


	






	private int getIndex(String firstName) {
		int index = -1;
		for (int i = 0; i < contactList.size(); i++) {
			if (firstName.equals(contactList.get(i).getFirstName())) {
				return i;
			}
		}
		return index;
	}
}