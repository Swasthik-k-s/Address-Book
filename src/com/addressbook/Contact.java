package com.addressbook;

import java.util.Objects;

public class Contact {

	public String firstName,lastName,address,city,state,zip,phoneNumber,email;

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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Contact [First Name=" + firstName + ", Last Name=" + lastName + ", Address=" + address + ", City=" + city
				+ ", State=" + state + ", Zip=" + zip + ", Phone Number=" + phoneNumber + ", Email=" + email + "]";
	}


}
