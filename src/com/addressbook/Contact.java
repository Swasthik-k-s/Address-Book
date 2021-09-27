package com.addressbook;

import java.util.Comparator;
import java.util.Objects;

public class Contact{

	public String firstName,lastName,address,city,state,zip,phoneNumber,email;

	/**
	 * Constructor to create a new Contact
	 * @param firstName - First name of the Person
	 * @param lastName - Last name of the Person
	 * @param address - Address of the Person
	 * @param city - City of the Person
	 * @param state - State of the Person
	 * @param zip - Zip code of the Person
	 * @param phoneNumber - Phone number of the Person
	 * @param email - Email ID of the Person
	 */
	Contact(String firstName, String lastName,String address,String city,String state,String zip,String phoneNumber,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;

	}
	
	private String getLastName() {
		return lastName;
	}

	private String getFirstName() {
		return firstName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCity() {
		return city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Contact [First Name=" + firstName + ", Last Name=" + lastName + ", Address=" + address + ", City=" + city
				+ ", State=" + state + ", Zip=" + zip + ", Phone Number=" + phoneNumber + ", Email=" + email + "]";
	}
	
	/**
	 * Lambda function to sort by Name
	 */
	static Comparator<Contact> compareByName = new Comparator<Contact>() {
		@Override
		public int compare(Contact o1, Contact o2) {
			return (o1.getFirstName()+o1.getLastName()).compareTo(o2.firstName+o2.getLastName());
		}
	};
	
	/**
	 * Lambda function to sort by City
	 */
	static Comparator<Contact> compareByCity = new Comparator<Contact>() {
		@Override
		public int compare(Contact o1, Contact o2) {
			return o1.getCity().compareTo(o2.getCity());
		}
	};
	
	/**
	 * Lambda function to sort by State
	 */
	static Comparator<Contact> compareByState = new Comparator<Contact>() {
		@Override
		public int compare(Contact o1, Contact o2) {
			return o1.getState().compareTo(o2.getState());
		}
	};
	
	/**
	 * Lambda function to sort by ZipCode
	 */
	static Comparator<Contact> compareByZip = new Comparator<Contact>() {
		@Override
		public int compare(Contact o1, Contact o2) {
			return o1.getZip().compareTo(o2.getZip());
		}
	};
}
