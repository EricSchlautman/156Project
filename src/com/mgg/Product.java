package com.mgg;

public class Product extends Item{

	private double quantity;
	private double value;
	public Product(String code, String type, String name, double value) {
		super(code, type, name);
		this.value = value;
	}
	
	public Product(String code, String type, String name, double value, double quantity) {
		super(code, type, name);
		this.value = value;
		this.quantity = quantity;
	}
	public Product(String code, String type, String name) {
		super(code, type, name);
	}

	public double getValue() {
		return value;
	}
	
	@Override
	public double cost() {
		return getValue();
	}
	
	@Override
	public double costUsed() {
		if(getType().equals("PU")) {
			return cost() - (cost() * 0.2);
		}
		return cost();
	}
	
	@Override
	public double totalCost() {
		if(getType().equals("PG")) {
			return getValue();
		}
		return getQuantity() * costUsed();
	}
	
	@Override
	public double getTax() {
		double tax = 0;
		if(getType().equals("PG")) {
			tax = totalCost() * 0.0725;
		}
		tax = totalCost() * 0.0725;
		return tax;
		
	}
	
	public double getQuantity() {
		return quantity;
	}

}
