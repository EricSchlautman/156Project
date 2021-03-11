package com.mgg;

import java.util.List;

/**
 * Class models a Sale 
 * 
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Sale  {

	private String codeSales;
	private Person customer;
	private Person salesperson;
	private List<Item> itemsSold;

	public Sale(String codeSales, Person customer, Person salesperson, 
			     List<Item> itemsSold) {

		this.codeSales = codeSales;
		this.customer = customer;
		this.salesperson = salesperson;
		this.itemsSold = itemsSold;
	}

	
	public String getCodeSales() {
		return this.codeSales;
	}

	
	public Person getCustomer() {
		return this.customer;
	}

	
	public Person getSalesperson() {
		return this.salesperson;
	}

	
	public List<Item> getItems() {
		return this.itemsSold;
	}
}
