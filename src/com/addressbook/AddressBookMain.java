package com.addressbook;

import java.util.*;

public class AddressBookMain {

	public static List<AddressBook> addressBook = new ArrayList<>();

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
		AddressBook bookName = new AddressBook(name);
		addressBook.add(bookName);
		bookName.ContactUpdate(bookName);
	}

	public static void openBook() {
		System.out.println("Enter the Existing Address Book Name");
		String name = scanner.next();
		for(AddressBook book: addressBook) {
			if(book.bookName.equals(name)) {
				book.ContactUpdate(book);
			}
		}
	}

	public static void viewBook() {
		for(AddressBook book: addressBook) {
			System.out.println("[ Address Book Name = " + book.bookName + " ]");
		}
	}
}
