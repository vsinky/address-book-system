package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	AddressBookDetails  ad = new AddressBookDetails ();
	public Map<String, AddressBookDetails > addressBookListMap = new HashMap<>();
	private String addressBookName;

	
	public void addAddressBook(String bookName) {

		boolean flag = true;

		while (flag) {
			System.out.println( "1] Add Contact\n" + "2] Display\n"
					+ "3] Edit contact\n" + "4] Delete Contact\n" + "5] Exit\n" + "Enter your Choice\n");
			int option = sc.nextInt();

			switch (option) {
			case 1:

				System.out.println("Enter no of contacts to be added");
				int noOfContacts = sc.nextInt();
				for (int i = 0; i < noOfContacts; i++) {
					ad.addContactDetails();
				}
				addressBookListMap.put(addressBookName, ad);
				System.out.println("Address Book Added Successfully");
				break;

			case 2:
				System.out.println("Enter the Person First name to Display ");
				String Name = sc.next();

				boolean list = ad.Display(Name);
				if (list) {
					System.out.println("Displayed the Contact");
				} else {
					System.out.println(" Cannot be Displayed");
				}

				break;

			case 3:
				System.out.println("Enter the Person First name to edit details: ");
				String personName = sc.next();

				boolean listEdited = ad.editContactDetails(personName);
				if (listEdited) {
					System.out.println("List Edited Successfully");
				} else {
					System.out.println("List Cannot be Edited");
				}

				break;
			case 4:
				System.out.println("Enter the Contact to be deleted:");
				String firstName = sc.next();
				boolean listDeleted = ad.deleteContact(firstName);
				if (listDeleted) {
					System.out.println("Deleted Contact from the List");
				} else {
					System.out.println("List Cannot be Deleted");
				}
				break;
			case 5:
				flag = false;
				break;

			}
		}
		}
	
	private void searchPersonByState(String stateName) {
		
	for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
		AddressBookDetails value = entry.getValue();
			System.out.println("The Address Book: " + entry.getKey());
			value.getPersonNameByState(stateName);
		}
	}

	private void searchPersonByCity(String cityName) {
		
		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			System.out.println("The Address Book: " + entry.getKey());
			value.getPersonNameByCity(cityName);
		}
	}

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice");
			System.out.println("Select an option\n" + "1] Add New Address Book\n"
					+ "2] Find Duplicate Entry in Address Book\n" + "3]Search Contact from a city\n"
					+ "4]Search Contact from a State\n" + "5]Exit\n" + "Enter your Choice\n");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				System.out.println("Enter the Name of Address Book: ");
				String addressBookName = sc.next();
				if (addressBook.addressBookListMap.containsKey(addressBookName)) {
					System.out.println("The Address book Already Exists");
					break;
				} else {
					addressBook.addAddressBook(addressBookName);
					break;
				}
			}
			case 2:
				for (Map.Entry<String, AddressBookDetails> entry : addressBook.addressBookListMap.entrySet()) {
					AddressBookDetails value = entry.getValue();
					System.out.println("Address Book Name: " + entry.getKey());
					value.checkDuplicate();
				}
			case 3:
				System.out.println("Enter Name of City: ");
				String CityName = sc.next();
				addressBook.searchPersonByCity(CityName);
				break;

			case 4: {
				System.out.println("Enter Name of State: ");
				String StateName = sc.next();
				addressBook.searchPersonByState(StateName);
				break;
			}

			case 5:
				flag = false;
				break;
			}
		}
	}
}
		
	
		
	