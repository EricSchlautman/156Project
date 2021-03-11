package com.mgg;

public class Service extends Item{
	private double hourlyRate;

	public Service(String code, String type, String name, double hourlyRate) {
		super(code, type, name);
		this.hourlyRate = hourlyRate;
	}

}
