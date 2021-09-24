package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

	static Map<String, AddressBook> bookMap = new HashMap<>();

	static Scanner scanner = new  Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		while(true) {
			System.out.println("1)Add New Address Book\n2)Open Existing Address Books\n3)View Existing Address Books\n4)Search Contact\n"
					+ "5)View Contacts by State/City\n6)Exit");
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
			case 5:
				viewContacts();
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
		if(bookMap.containsKey(name)) {
			System.out.println("AddressBook Name already exists");
		} else {
			AddressBook book = new AddressBook(name);
			bookMap.put(name, book);
			book.ContactUpdate(bookMap.get(name));
		}
	}

	/**
	 * Method to Open the existing Address Book
	 */
	private static void openBook() {
		System.out.println("Enter the Existing Address Book Name");
		String name = scanner.next();
		if(bookMap.containsKey(name)) {
			AddressBook book2 = bookMap.get(name);
			book2.ContactUpdate(bookMap.get(name));
		} else {
			System.out.println("Address Book Name not found");
		}
	}

	/**
	 * Method to view all the Address Books
	 */
	private static void viewBook() {
		if(bookMap.isEmpty()) {
			System.out.println("No Address Books are added");
		}
		for(Map.Entry<String,AddressBook> entry: bookMap.entrySet()) {
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
			
			for (AddressBook addressBook : bookMap.values()) {
				List<Contact> sameCityContacts = addressBook.contacts.stream().filter((contact) -> {
					return contact.city.equals(cityName);
				}).collect(Collectors.toList());

				System.out.println("Number of Contacts = " + sameCityContacts.size());
				for (Contact contact : sameCityContacts) {
					System.out.println(contact);
				}
			}
			break;
		case 2:
			System.out.println("Enter State Name");
			String stateName = scanner.next();
			
			for (AddressBook addressBook : bookMap.values()) {
				List<Contact> sameStateContacts = addressBook.contacts.stream().filter((contact) -> {
					return contact.state.equals(stateName);
				}).collect(Collectors.toList());

				System.out.println("Number of Contacts = " + sameStateContacts.size());
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

	/**
	 * Method to view the contacts ordered by city or state
	 */
	private static void viewContacts() {
		Map<String, List<Contact>> stateMap = new HashMap<String, List<Contact>>();
		Map<String, List<Contact>> cityMap = new HashMap<String, List<Contact>>();

		System.out.println("View Contacts by\n1) City\n2) State\n3) Back");
		int choice = scanner.nextInt();

		switch(choice) {
		case 1:
			for(AddressBook addressBook : bookMap.values()) {
				addressBook.returnContacts().stream().forEach(contact -> {
					List<Contact> contacts = cityMap.get(contact.city);
					if(contacts == null) {
						contacts = new ArrayList<>();
					}
					contacts.add(contact);
					cityMap.put(contact.city, contacts);
				});
			}
			for(Map.Entry<String, List<Contact>> item : cityMap.entrySet()) {
				System.out.println("City : " + item.getKey());
				System.out.println("Number of Contacts : " + item.getValue().size());
				item.getValue().stream().forEach(contact -> {
					System.out.println(contact);
				});
			}
			break;
		case 2:
			for(AddressBook addressBook : bookMap.values()) {
				addressBook.returnContacts().stream().forEach(contact -> {
					List<Contact> contacts = stateMap.get(contact.state);
					if(contacts == null) {
						contacts = new ArrayList<>();
					}
					contacts.add(contact);
					stateMap.put(contact.state, contacts);
				});
			}
			for(Map.Entry<String, List<Contact>> item : stateMap.entrySet()) {
				System.out.println("State : " + item.getKey());
				System.out.println("Number of Contacts : " + item.getValue().size());
				item.getValue().stream().forEach(contact -> {
					System.out.println(contact);
				});
			}
			break;
		default:
			break;
		}
	}
}
