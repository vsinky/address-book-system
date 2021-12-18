package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

	Scanner sc = new Scanner(System.in);
	AddressBookDetails ad = new AddressBookDetails();
	public Map<String, AddressBookDetails> addressBookListMap = new HashMap<>();
	private String addressBookName;
	public static ArrayList<Contact> contact;
	
	public void addAddressBook(String addressBookName) {
		AddressBook address = new AddressBook();
		boolean flag = true;

		while (flag) {
			System.out.println("1] Add Contact\n" + "2] Display\n" + "3] Edit contact\n" + "4] Delete Contact\n"
					+ "5] Exit\n" + "Enter your Choice\n");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				ad.addContact();
//				System.out.println("Enter no of contacts to be added");
//				int noOfContacts = sc.nextInt();
//				for (int i = 0; i < noOfContacts; i++) {
//					ad.addContact();
//				}
//				addressBookListMap.put(addressBookName, ad);
//				System.out.println("Address Book Added Successfully");
				break;

			case 2:

				System.out.println("Displayed the Contact");
				ad.display();
				break;

			case 3:
				System.out.println("Enter the Person First name to edit details: ");
				String personName = sc.next();

				boolean listEdited = ad.editContact(personName);
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
		addressBookListMap.put(addressBookName, ad);
		System.out.println("Address Book Added Successfully");
	}

	void searchPersonByState(String stateName) {

		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			System.out.println("The Address Book: " + entry.getKey());
			value.getPersonNameByState(stateName);
		}
	}

	public void searchPersonByCity(String cityName) {

		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			System.out.println("The Address Book: " + entry.getKey());
			value.getPersonNameByCity(cityName);
		}
	}

	public void CountByState(String state) {
		int count = 0;
		for (Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			for (int i = 0; i < (entry.getValue()).contact.size(); i++) {
				Contact contact = entry.getValue().contact.get(i);

				if (state.equals(contact.getState())) {
					count++;
				}

			}
		}
		System.out.println("Total Person Count in state " + state + ": " + count);
	}

	public void CountByCity(String city) {
		int countPersonInCity = 0;
		for (Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			for (int i = 0; i < (entry.getValue()).contact.size(); i++) {
				Contact d = entry.getValue().contact.get(i);

				if (city.equals(d.getCity())) {
					countPersonInCity++;
				}

			}
		}
		System.out.println("Total number of people in this city " + city + ": " + countPersonInCity);
	}

	void sortContactByName() {
		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			List<Contact> sortedList = value.contact.stream().sorted(Comparator.comparing(Contact::getFirstName))
					.collect(Collectors.toList());

			for (Contact contact : sortedList) {
				System.out.println("First Name: " + contact.getFirstName());
				System.out.println("Last Name: " + contact.getLastName());
			}
		}
	}

	void sortContactByState() {
		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			List<Contact> sortedList = value.contact.stream().sorted(Comparator.comparing(Contact::getState))
					.collect(Collectors.toList());

			for (Contact contact : sortedList) {
				System.out.println("First Name: " + contact.getFirstName());
				System.out.println("Last Name: " + contact.getLastName());

			}
		}
	}

	public void sortContactByCity() {
		for (Map.Entry<String, AddressBookDetails> entry : addressBookListMap.entrySet()) {
			AddressBookDetails value = entry.getValue();
			List<Contact> sortedList = value.contact.stream().sorted(Comparator.comparing(Contact::getCity))
					.collect(Collectors.toList());

			for (Contact contact : sortedList) {
				System.out.println("First Name: " + contact.getFirstName());
				System.out.println("Last Name: " + contact.getLastName());
			}
		}
	}

	//file IO operation
    public static void writeData(AddressBook addressBook) {
        StringBuffer personBuffer = new StringBuffer();
        contact.forEach(person -> {
            String personDataString = person.toString().concat("\n");
            personBuffer.append(personDataString);
        });
        try {
            Files.write(Paths.get("Data.txt"), personBuffer.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void readData(AddressBook addressBoo) {
        try {
            Files.lines(new File("Data.txt").toPath()).map(String::trim).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


	
	
}
