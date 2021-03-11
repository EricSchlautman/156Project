package com.mgg;

import java.util.List;


/**
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Person {
	String code;
	String type;
	String lastName;
	String firstName;
	Address address;
	List <String> emailAddresses;
	
	public String getCode() {
		return this.code;
	}
	public String getType() {
		return this.type;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public Address getAddress() {
		return this.address;
	}
	public List<String> getEmailAddresses() {
		return this.emailAddresses;
	}
	public Person(String code, String type, String lastName, String firstName, Address address,
			       List<String> emailAddresses) {
		this.code = code;
		this.type = type;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.emailAddresses = emailAddresses;
	}
	
	
	
}
