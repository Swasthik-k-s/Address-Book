package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

	public static Map<String, AddressBook> map = new HashMap<>();

	static Scanner scanner = new  Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		while(true) {
			System.out.println("1)Add New Address Book\n2)Open Existing Address Books\n3)View Existing Address Books\n4)Search Contact\n5)Exit");
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
			case 4:
				searchContact();
				break;
			default:
				System.out.println("Thank You");
				return;
			}
		}
	}

	/**
	 * Method to add a Address Book
	 */
	private static void addBook() {
		System.out.println("Enter the Address Book Name");
		String name = scanner.next();
		if(map.containsKey(name)) {
			System.out.println("AddressBook Name already exists");
		} else {
			map.put(name, new AddressBook(name));
			AddressBook.ContactUpdate(map.get(name));
		}
	}

	/**
	 * Method to Open the existing Address Book
	 */
	private static void openBook() {
		System.out.println("Enter the Existing Address Book Name");
		String name = scanner.next();
		if(map.containsKey(name)) {
			AddressBook.ContactUpdate(map.get(name));
		} else {
			System.out.println("Address Book Name not found");
		}
	}

	/**
	 * Method to view all the Address Books
	 */
	private static void viewBook() {
		if(map.isEmpty()) {
			System.out.println("No Address Books are added");
		}
		for(Map.Entry<String,AddressBook> entry: map.entrySet()) {
			System.out.println("Addres Book Name = " + entry.getKey() + "\nNumber of Contacts = " + entry.getValue().contacts.size());
		}
	}

	/**
	 * Method to search the contact based on city and state from all the address books
	 */
	private static void searchContact() {
		System.out.println("1)Search by City\n2)Search by State\n3)Back");
		int choice = scanner.nextInt();

		switch(choice) {
		case 1:
			System.out.println("Enter City Name");
			String cityName = scanner.next();
			for (AddressBook addressBook : map.values()) {
				List<Contact> sameCityContacts = addressBook.contacts.stream().filter((contact) -> {
					return contact.city.equals(cityName);
				}).collect(Collectors.toList());

				for (Contact contact : sameCityContacts) {
					System.out.println(contact);
				}
			}
			break;
		case 2:
			System.out.println("Enter State Name");
			String stateName = scanner.next();
			for (AddressBook addressBook : map.values()) {
				List<Contact> sameStateContacts = addressBook.contacts.stream().filter((contact) -> {
					return contact.state.equals(stateName);
				}).collect(Collectors.toList());

				if(sameStateContacts.size() == 0) {
					System.out.println("No Contacts found from State " + stateName);
					break;
				}
				
				for (Contact contact : sameStateContacts) {
					System.out.println(contact);
				}
			}
			break;
		default:
			break;
		}
	}
}
