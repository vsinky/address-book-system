package com.bridgelabz.addressbooksystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter your choice");
			System.out.println("Select an option\n" + "1] Add New Address Book\n" + "2]Search Contact from a city\n"
					+ "3]Search Contact from a State\n" + "4]Count Contact By State\n" + "5]Count Contact By City\n"
					+ "6]Sort Contact By Name\n" + "7]Sort Contact By City\n" + "8]Sort Contact By State\n" + "9]Write data\n" + "10]Read data\n" + "11]Exit\n"
					+ "Enter your Choice\n");
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
				System.out.println("Enter Name of City: ");
				String CityName = sc.next();
				addressBook.searchPersonByCity(CityName);
				break;

			case 3:
				System.out.println("Enter Name of State: ");
				String StateName = sc.next();
				addressBook.searchPersonByState(StateName);
				break;

			case 4:
				System.out.println("Enter Name of State: ");
				String stateName2 = sc.next();
				addressBook.CountByState(stateName2);
				break;

			case 5:
				System.out.println("Enter Name of City: ");
				String cityName2 = sc.next();
				addressBook.CountByCity(cityName2);
				break;

			case 6:
				System.out.println("Sort Contact");
				addressBook.sortContactByName();

			case 7:
				System.out.println("Sort Contact");
				addressBook.sortContactByCity();
				break;

			case 8:
				System.out.println("Sort Contact");
				addressBook.sortContactByState();
				break;

			case 9:
				addressBook.writeData(addressBook);
				break;
			case 10:
				addressBook.readData(addressBook);
				break;
			case 11:
				flag = false;
				break;
			}
		}
}
	}
