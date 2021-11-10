package com.bridgelabz.addressbooksystem;
import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name : ");
		String firstName = sc.next();
		System.out.println("Enter the Last Name : ");
		String lastName = sc.next();
		System.out.println("Enter the Address : ");
		String address = sc.next();
		System.out.println("Enter the City : ");
		String city = sc.next();
		System.out.println("Enter the State : ");
		String state = sc.next();
		System.out.println("Enter the ZIP Code : ");
		long zipCode = sc.nextLong();
		System.out.println("Enter the Phone Number : ");
		long phoneNumber = sc.nextLong();
		System.out.println("Enter the E-mail: ");
		String email = sc.next();
	}
}