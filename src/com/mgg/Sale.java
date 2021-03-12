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
	private String codeStore;
	private Person customer;
	private Person salesperson;
	private List<Item> itemsSold;

	public Sale(String codeSales, String codeStore, Person customer, Person salesperson, 
			     List<Item> itemsSold) {

		this.codeSales = codeSales;
		this.codeStore = codeStore;
		this.customer = customer;
		this.salesperson = salesperson;
		this.itemsSold = itemsSold;
	}

	public String getCodeSales() {
		return this.codeSales;
	}

	public String getCodeStore() {
		return this.codeStore;
	}
	
	public Person getCustomer() {
		return this.customer;
	}

	
	public Person getSalesperson() {
		return this.salesperson;
	}

	
	@Override
	public String toString() {
		return "Sale [codeSales=" + codeSales + ", codeStore=" + codeStore + ", customer=" + customer + ", salesperson="
				+ salesperson + ", itemsSold=" + itemsSold + "]";
	}

	public List<Item> getItems() {
		return this.itemsSold;
	}
}
