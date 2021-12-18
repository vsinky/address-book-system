package com.bridgelabz.addressbooksystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBookDetails {
	Scanner sc = new Scanner(System.in);
	public ArrayList<Contact> contact = new ArrayList<>();
	public Map<String, ArrayList<Contact>> personByState;
	public Map<String, ArrayList<Contact>> personByCity;

	public AddressBookDetails() {
		//personByCity = new Map<String, ArrayList<Contact>>();
		//personByState = new Map<String, ArrayList<Contact>>();
		contact = new ArrayList<>();
	}

	public List<Contact> addContact() {
		
		System.out.println("Enter the contact details:");
		System.out.println("Enter First Name");
		String firstName = sc.next();

		if (checkDuplicate(firstName)) {
			System.out.println("Person is already exist");
		} else {
			System.out.println("Enter last Name");
			String lastName = sc.next();

			System.out.println("Enter Address ");
			String address = sc.next();

			System.out.println("Enter City ");
			String city = sc.next();

			System.out.println("Enter State ");
			String state = sc.next();

			System.out.println("Enter  Email ");
			String email = sc.next();

			System.out.println("Enter phone Number");
			String phoneNumber = sc.next();

			System.out.println("Enter Zip code");
			String zip = sc.next();

			Contact contactDetails = new Contact(firstName, lastName, address, city, state, email, phoneNumber, zip);
			contact.add(contactDetails);
		
			System.out.println("contactDetails");
		}
		return contact;
		
	}

	public boolean editContact(String Name) {
		int flag = 0;
		for (Contact contact : contact) {
			if (contact.getFirstName().equals(Name)) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Address: ");
				String address = sc.next();
				contact.setAddress(address);
				System.out.println("Enter City: ");
				String city = sc.next();
				contact.setCity(city);
				System.out.println("Enter State: ");
				String state = sc.next();
				contact.setState(state);
				System.out.println("Enter Email: ");
				String email = sc.next();
				contact.setEmail(email);
				System.out.println("Enter Phone Number:");
				String phoneNumber = sc.next();
				contact.setPhoneNumber(phoneNumber);
				System.out.println("Enter Zip Code: ");
				String zip = sc.next();
				contact.setZip(zip);
				flag = 1;
			}
		}
		return flag == 1;
	}

	public void display() {

		contact.stream().forEach(System.out::println);
	}

	public boolean deleteContact(String name) {
		int flag = 0;
		for (Contact contact : contact) {
			if (contact.getFirstName().equals(name)) {
				contact.remove(contact);
				flag = 1;
				break;
			}
		}
		return flag == 1;
	}

	public boolean checkDuplicate(String firstname) {
		int flag = 0;
		for (Contact p : contact) {
			if (p.getFirstName().equals(firstname)) {
				flag = 1;
				break;
			}
		}
		return flag == 1;
	}

	public void getPersonNameByState(String stateName) {
		List<Contact> list = contact.stream().filter(p -> p.getState().equals(stateName)).collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("First Name: " + contact.getFirstName());
			System.out.println("Last Name: " + contact.getLastName());
		}
	}

	public void getPersonNameByCity(String cityName) {
		List<Contact> list = contact.stream().filter(p -> p.getCity().equals(cityName)).collect(Collectors.toList());
		for (Contact contact : list) {
			System.out.println("First Name: " + contact.getFirstName());
			System.out.println("Last Name: " + contact.getLastName());
		}
	}
}