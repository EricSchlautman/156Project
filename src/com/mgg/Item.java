package com.mgg;


/**
 * Class models an 'item' object sold at a store
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Item {
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
	public Item(String code, String type, String name, double price) {
		this.code = code;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public Item(String code, String type, String name) {
		this.code = code;
		this.type = type;
		this.name = name;
	}
	
	
}
