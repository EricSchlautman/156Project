package com.mgg;

public class Service extends Item{
	private double hourlyRate;
	private double hoursWorked;
	private String firstName;
	private String lastName;
	public Service(String code, String type, String name, double hourlyRate) {
		super(code, type, name);
		this.hourlyRate = hourlyRate;
	}
	
	public Service(String code, String type, String name, double hourlyRate, double hoursWorked, String firstName, String lastName) {
		super(code, type, name);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public double getHourlyRate() {
		return hourlyRate;
	}

	@Override
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public double totalCost() {
		return getHoursWorked() * getHourlyRate();
	}
	
	@Override
	public double getTax() {
		double tax = totalCost() * 0.0285;
		return tax;
	}
	
	

}
