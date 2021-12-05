package com.bridgelabz.addressbooksystem;

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
    
    public void addContactDetails(){
        System.out.println("Enter the contact details:");
        System.out.println("Enter First Name");
        String firstName = sc.next();
        
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
        System.out.println(contactDetails);

    }
    
    public boolean editContactDetails(String Name)
    {
        int flag = 0;
        for(Contact contact: contact)
        {
            if(contact.getFirstName().equals(Name))
            {

                System.out.println("Select an option to edit\n"
                        +"1] First Name\n"
                        +"2] Last Name\n"
                        +"3] Address\n"
                        +"4] City\n"
                        +"5] State\n"
                        +"6] Email"
                        +"7] phone Number\n"
                        +"8] ZIP code\n");

                int choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                    {
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        contact.setFirstName(firstName);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter last name: ");
                        String lastName = sc.next();
                        contact.setLastName(lastName);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Enter Address: ");
                        String address = sc.next();
                        contact.setAddress(address);
                        break;
                    }
                    case 4:
                    {
                        System.out.println("Enter City: ");
                        String city = sc.next();
                        contact.setCity(city);
                        break;
                    }
                    case 5:
                    {
                        System.out.println("Enter State: ");
                        String state =sc.next();
                        contact.setState(state);
                        break;
                    }
                    case 6:
                    {
                        System.out.println("Enter Email: ");
                        String email = sc.next();
                        contact.setEmail(email);
                        break;
                    }
                    case 7:
                    {
                        System.out.println("Enter Phone Number:");
                        String phoneNumber = sc.next();
                        contact.setPhoneNumber(phoneNumber);
                        break;
                    }
                    case 8:
                    {
                        System.out.println("Enter Zip Code: ");
                        String zip = sc.next();
                        contact.setZip(zip);
                        break;
                    }

                }
                while (choice < 5 || choice > 0);

                flag = 1;
               break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    
    public boolean Display(String Name)
    {
        int flag = 0;
        for(Contact contact: contact)
        {
            if(contact.getFirstName().equals(Name))
            {
                System.out.println(contact);
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    
    public boolean deleteContact(String name) {
        int flag = 0;
        for(Contact contact: contact)
        {
            if(contact.getFirstName().equals(name))
            {
                contact.remove(contact);
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return true;
        else
            return false;
    }
   
    public void checkDuplicate() {
        Set<String> ContactSet = new HashSet<>();
        
        Set<Contact> filterSet = contact.stream().filter(n -> !ContactSet.add(n.getFirstName())).collect(Collectors.toSet());

        for (Contact contact : filterSet) {
            System.out.println("The Duplicate Contact is: " + contact.getFirstName() );
        }


    }

	public void getPersonNameByState(String stateName) {
		List<Contact> list  = contact.stream().filter(p ->p.getState().equals(stateName)).collect(Collectors.toList());
        for(Contact contact:list){
            System.out.println("First Name: "+contact.getFirstName());
            System.out.println("Last Name: "+contact.getLastName());
        }
	}

	public void getPersonNameByCity(String cityName) {
		 List<Contact> list  = contact.stream().filter(p ->p.getCity().equals(cityName)).collect(Collectors.toList());
	        for(Contact contact: list){
	            System.out.println("First Name: "+contact.getFirstName());
	            System.out.println("Last Name: "+contact.getLastName());
	        }
	}
}