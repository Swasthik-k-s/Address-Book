package com.addressbook;

import java.util.*;

public class AddressBookMain {

	public static Map<String, AddressBook> map = new HashMap<>();

	static Scanner scanner = new  Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		while(true) {
			System.out.println("1)Add New Address Book\n2)Open Existing Address Books\n3)View Existing Address Books\n4)Exit");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				addBook();
				break;
			case 2:
				openBook();
				break;
			case 3:
				viewBook();
				break;
			default:
				System.out.println("Thank You");
				return;
			}
		}
	}

	public static void addBook() {
		System.out.println("Enter the Address Book Name");
		String name = scanner.next();
		if(map.containsKey(name)) {
			System.out.println("AddressBook Name already exists");
		} else {
			map.put(name, new AddressBook(name));
			AddressBook.ContactUpdate(map.get(name));
		}
	}

	public static void openBook() {
		System.out.println("Enter the Existing Address Book Name");
		String name = scanner.next();
		if(map.containsKey(name)) {
			AddressBook.ContactUpdate(map.get(name));
		} else {
			System.out.println("Address Book Name not found");
		}
	}

	public static void viewBook() {
		if(map.isEmpty()) {
			System.out.println("No Address Books are added");
		}
		for(Map.Entry<String,AddressBook> entry: map.entrySet()) {
			System.out.println("Addres Book Name = " + entry.getKey() + "\nNumber of Contacts = " + entry.getValue().contacts.size());
		}
	}
}
