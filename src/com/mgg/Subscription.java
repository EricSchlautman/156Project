package com.mgg;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Subscription extends Item {
	private double annualFee;
//	private String startDate;
//	private String endDate;
	private String startDate;
	private String endDate;

	public Subscription(String code, String type, String name, double annualFee,
						String startDate, String endDate) {
		super(code, type, name);
		this.annualFee = annualFee;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Subscription(String code, String type, String name, double annualFee) {
		super(code, type, name);
		this.annualFee = annualFee;
	}

	public double getAnnualFee() {
		return annualFee;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	@Override
	public Integer getAge() {
		LocalDate startDate = LocalDate.parse(getStartDate());
		LocalDate endDate = LocalDate.parse(getEndDate());
    	int days = (int) ChronoUnit.DAYS.between(startDate, endDate);
    	return days;
    }
	@Override
	public double totalCost() {
		double age = (double) getAge();
		age = age / 365;
		double total = age * getAnnualFee();
		return total;
	}
	@Override
	public double cost() {
		return getAnnualFee();
	}
	
}
