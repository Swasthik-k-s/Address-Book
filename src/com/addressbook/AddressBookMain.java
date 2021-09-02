package com.addressbook;

import java.util.*;

public class AddressBookMain {

	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner scanner = new  Scanner(System.in);
		
		System.out.println("Enter the First Name");
		String firstName = scanner.nextLine();
		System.out.println("Enter the Last Name");
		String lastName = scanner.nextLine();
		System.out.println("Enter the Address");
		String address = scanner.nextLine();
		System.out.println("Enter the City");
		String city = scanner.nextLine();
		System.out.println("Enter the State");
		String state = scanner.nextLine();
		System.out.println("Enter the Zip Code");
		String zip = scanner.nextLine();
		System.out.println("Enter the Phone Number");
		String phone = scanner.nextLine();
		System.out.println("Enter the Email");
		String email = scanner.nextLine();
		scanner.close();
		
		Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);
		
		System.out.println(contact);
	}

}
