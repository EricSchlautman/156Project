package com.mgg;

/**
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Store {
	String storeCode;
	String managerCode;
	Person manager;
	Address address;
	
	
	public String getStoreCode() {
		return this.storeCode;
	}
	public String getManagerCode() {
		return this.managerCode;
	}
	public Address getAddress() {
		return this.address;
	}
	public Person getManager() {
		return this.manager;
	}
	public void setManager(Person manager) {
		this.manager = manager;
	}
	public Store(String storeCode, String managerCode, Address address) {
		this.storeCode = storeCode;
		this.managerCode = managerCode;
		this.address = address;
	}
	
	
	
}
