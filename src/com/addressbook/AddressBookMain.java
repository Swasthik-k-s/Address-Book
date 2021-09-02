package com.addressbook;

import java.util.*;

public class AddressBookMain {

	static List<Contact> addressBook = new ArrayList<>();
	static Scanner scanner = new  Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program");
		
		while(true) {
			
			System.out.println("1)Add a Contact\n2)Edit a Contact\n3)View Contacts\n4)Exit");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				addContact();
				break;
			case 2:
				editContact();
				break;
			case 3:
				showAddressBook();
				break;
			default:
				return;
			}
			
		}
	}
	
	public static void addContact() {
		
		System.out.println("Enter the First Name");
		String firstName = scanner.next();
		System.out.println("Enter the Last Name");
		String lastName = scanner.next();
		System.out.println("Enter the Address");
		String address = scanner.next();
		System.out.println("Enter the City");
		String city = scanner.next();
		System.out.println("Enter the State");
		String state = scanner.next();
		System.out.println("Enter the Zip Code");
		String zip = scanner.next();
		System.out.println("Enter the Phone Number");
		String phone = scanner.next();
		System.out.println("Enter the Email");
		String email = scanner.next();
		
		
		Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);
		addressBook.add(contact);
	}
	
	public static void showAddressBook() {
		
		for(int i=0;i<addressBook.size();i++) {
			System.out.println((i+1) + "\n" + addressBook.get(i));
		}
	}
	
	public static void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name");
		String firstName = scanner.next();
		System.out.println("Enter the Last Name");
		String lastName = scanner.next();
		Contact editContact = getContact(firstName,lastName);
		
		if(editContact == null) {
			System.out.println("Name does not exist in the Address Book");
		} else {
			while(true) {
				System.out.println("Select field to Edit the Contact");
				System.out.println("1)First_Name\t2)Last_Name\t3)Address\n4)City\t\t5)State\t\t6)Zip_Code\n7)Phone_Number\t8)Email\t\t9)Back");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Enter the New First Name");
					String fName = scanner.next();
					editContact.firstName = fName;
					break;
				case 2:
					System.out.println("Enter the New Last Name");
					String lName = scanner.next();
					editContact.lastName = lName;
					break;
				case 3:
					System.out.println("Enter the New Address");
					String address = scanner.next();
					editContact.address = address;
					break;
				case 4:
					System.out.println("Enter the New City");
					String city = scanner.next();
					editContact.city = city;
					break;
				case 5:
					System.out.println("Enter the New State");
					String state = scanner.next();
					editContact.state = state;
					break;
				case 6:
					System.out.println("Enter the New Zip");
					String zip = scanner.next();
					editContact.zip = zip;
					break;
				case 7:
					System.out.println("Enter the New Phone Number");
					String phone = scanner.next();
					editContact.phoneNumber = phone;
					break;
				case 8:
					System.out.println("Enter the New Email");
					String email = scanner.next();
					editContact.email = email;
					break;
				default:
					return;
				}
			}
			
		}
	}
	
	public static Contact getContact(String fname,String lname) {
		for(Contact contact:addressBook) {
			if(contact.firstName.equals(fname) && contact.lastName.equals(lname)) {
				return contact;
			}
		}
		return null;
	}

}
