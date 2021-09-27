package com.addressbook;

import java.util.Objects;

public class Contact implements Comparable<Contact>{

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

	@Override
	public int compareTo(Contact o) {
		return (this.firstName+this.lastName).compareTo(o.getFirstName()+o.getLastName());
	}
}
