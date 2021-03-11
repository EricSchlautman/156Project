package com.mgg;

/**
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Address {
	String street;
	String city;
	String state;
	String zipcode;
	String country;
	
	public String getStreet() {
		return this.street;
	}
	public String getCity() {
		return this.city;
	}
	public String getState() {
		return this.state;
	}
	public String getZipcode() {
		return this.zipcode;
	}
	public String getCountry() {
		return this.country;
	}
	public Address(String street, String city, String state, String zipcode, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}
	
	public void addressToString() {
		System.out.printf("%s \n%s, %s %s\n%s",street, city, state, zipcode, country);
	}
	
	
}
