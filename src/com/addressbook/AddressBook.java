package com.addressbook;

import java.util.*;

public class AddressBook {

	String bookName;
	static List<Contact> contacts;
	static Scanner scanner = new  Scanner(System.in);

	public AddressBook(String bookName) {
		this.bookName = bookName;
		contacts  = new ArrayList<>();
	}

	public String getBookName(String name) {
		return bookName;
	}

	public void ContactUpdate(AddressBook addressBook) {

		System.out.println("Address Book Name = " + addressBook.bookName);

		while(true) {

			System.out.println("1)Add a Contact\n2)Delete Contact\n3)Edit a Contact\n4)View Contacts\n5)Back");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();

			switch(choice) {
			case 1:
				addContact();
				break;
			case 2:
				deleteContact();
				break;
			case 3:
				editContact();
				break;
			case 4:
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
		contacts.add(contact);
	}

	public static void showAddressBook() {

		for(int i=0;i<contacts.size();i++) {
			System.out.println((i+1) + "\n" + contacts.get(i));
		}
	}

	public static void deleteContact() {
		Contact deleteContact = getContact();

		if(deleteContact == null) {
			System.out.println("Name does not exist in the Address Book");
		} else {
			contacts.remove(deleteContact);
			System.out.println("Contact Deleted Successfully");
		}
	}

	public static void editContact() {

		Scanner sc = new Scanner(System.in);
		Contact editContact = getContact();

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

	public static Contact getContact() {
		System.out.println("Enter the First Name");
		String fname = scanner.next();
		System.out.println("Enter the Last Name");
		String lname = scanner.next();

		for(Contact contact:contacts) {
			if(contact.firstName.equals(fname) && contact.lastName.equals(lname)) {
				return contact;
			}
		}
		return null;
	}
}
