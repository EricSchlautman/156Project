package com.mgg;


/**
 * Class models an 'item' object sold at a store
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public abstract class Item {
	private String code;
	private String type;
	private String name;
	private double price;
	
	public String getCode() {
		return code;
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double cost() {
		return -1;
	}
	public double costUsed() {
		return -1;
	}
	public double totalCost() {
		return -1;
	}
	public String getFirstName() {
		return "ERROR";
	}
	public String getLastName() {
		return "ERROR";
	}
	public double getHourlyRate() {
		return -1;
	}

	public double getHoursWorked() {
		return -1;
	}
	public Integer getAge() {
		return -1;
	}
	
	public double getTax() {
		return -1;
	}
	public Item(String code, String type, String name, double price) {
		this.code = code;
		this.type = type;
		this.name = name;
	}
	
	public Item(String code, String type, String name) {
		this.code = code;
		this.type = type;
		this.name = name;
	}
	
	
}
