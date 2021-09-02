package com.addressbook;

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
	public String toString() {
		return firstName + " " + lastName + ",\n" + address + ", " + city + ", " + state + " - " + zip + ",\nMobile = " + phoneNumber + 
				",\nEmail = " + email + "\n";
	}
}
