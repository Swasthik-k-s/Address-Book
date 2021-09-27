package com.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {

	String bookName;
	List<Contact> contacts = new ArrayList<Contact>();
	static Scanner scanner = new  Scanner(System.in);

	public AddressBook(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * Method to perform Contact operations
	 * @param book - Points to the list of contacts present in the Address Book
	 */
	public void ContactUpdate(AddressBook book) {

		this.contacts = book.contacts;
		this.bookName = book.bookName;
		System.out.println("Address Book Name = " + bookName);

		while(true) {

			System.out.println("1)Add a Contact\n2)Delete Contact\n3)Edit a Contact\n4)View Contacts\n5)Sort by Name\n"
					+ "6)Sort by Place\n7)Back");
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
			case 5:
				sortContacts();
				break;
			case 6:
				sortByPlace();
				break;
			default:
				return;
			}
		}
	}

	/**
	 * Method to add Contact to the Address Book
	 */
	public void addContact() {

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

		List<Contact> existingContact = contacts.stream().filter(con->{
			if (con.equals(contact)) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());

		if (existingContact.size() == 0) {
			contacts.add(contact);
		}
		else {
			System.out.println("This Contact Already exists in the Address Book");
		}
	}

	/**
	 * Method to display the contacts present in the Address Book
	 */
	public void showAddressBook() {
		for(Contact contact: contacts) {
			System.out.println(contact);
		}
	}

	/**
	 * Method to return the contacts from current address book
	 * @return - list of contacts
	 */
	public List<Contact> returnContacts() {
		return contacts;
	}

	/**
	 * Method to delete the contact from the Address Book
	 */
	public void deleteContact() {
		Contact deleteContact = getContact();

		if(deleteContact == null) {
			System.out.println("Name does not exist in the Address Book");
		} else {

			contacts.remove(deleteContact);
			System.out.println("Contact Deleted Successfully");
		}
	}

	/**
	 * Method to edit the contact 
	 */
	public void editContact() {

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

	/**
	 * Method to find contact based on first and last name
	 * @return - returns a contact
	 */
	private Contact getContact() {
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

	/**
	 * Method to sort the contacts based on Name
	 */
	private void sortContacts() {
		Collections.sort(contacts, Contact.compareByName);
		showAddressBook();
	}

	/**
	 * Method to sort the contacts based on Location
	 */
	private void sortByPlace() {
		System.out.println("1)Sort by City\n2)Sort by State\n3)Sort by Zip Code\n4)Back");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(contacts,Contact.compareByCity);
			showAddressBook();
			break;
		case 2:
			Collections.sort(contacts,Contact.compareByState);
			showAddressBook();
			break;
		case 3:
			Collections.sort(contacts,Contact.compareByZip);
			showAddressBook();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Method to read the file and check contacts
	 * @param br - path to read the file from
	 */
	public void readContact(BufferedReader br) {
		Contact contact;
		String row;

		try {
			while ((row = br.readLine()) != null) {
				String[] data = row.split(",");
				contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
				String name = data[0] + " " + data[1];
				boolean exists = false;
				for(Contact con: contacts) {
					if(con.firstName + " " + con.lastName == name) {
						exists = true;
					}
				}
				if (exists == false) {
					contacts.add(contact);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to write the contact into a file
	 * @param fileName - file to write the data
	 */
	public void writeContact(String fileName) {
		try {
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(fileName, false));
			String str = "hello";
			for (Contact c : contacts) {
				f_writer.write(String.join(",", c.firstName, c.lastName, c.address, c.city, c.state, c.zip,
						c.phoneNumber, c.email));
				f_writer.write("\n");
			}
			f_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param file - File to read the CSV file
	 */
	public void readCSV(String file) {
		try {

			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			Contact contact;

			// print Data
			for (String[] row : allData) {
				contact = new Contact(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
				String name = row[0] + " " + row[1];
				boolean exists = false;
				for(Contact con: contacts) {
					if(con.firstName + " " + con.lastName == name) {
						exists = true;
					}
				}
				if (exists == false) {
					contacts.add(contact);
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to write the CSV file
	 * @param filePath - Path on which to write the CSV file
	 */
	public void writeCSV(String filePath) {
		File file = new File(filePath);
		try {
			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile, ',', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			
			String[] header = { "FistName", "Lastname", "Address", "City", "State", "Zip", "Phone Number", "Email" };
			writer.writeNext(header);

			for (Contact c : contacts) {
				String[] data1 = { c.firstName, c.lastName, c.address, c.city, c.state, c.zip, c.phoneNumber, c.email };
				writer.writeNext(data1);
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
