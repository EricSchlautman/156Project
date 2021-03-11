package com.mgg;

public class Subscription extends Item {
	private double annualFee;

	public Subscription(String code, String type, String name, double annualFee) {
		super(code, type, name);
		this.annualFee = annualFee;
	}

}
