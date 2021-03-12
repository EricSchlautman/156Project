package com.mgg;

import java.util.List;

/**
 * Program reads in data from .csv file converts it to the appropriate object
 * and outputs data to properly formatted XML/JSON file.
 * 
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class DataConverter {
	
	public static void reportReceipts (List<Sale> sales, List<Person> persons) {
		
		for(Sale s : sales) {
			double subtotal = 0;
			double tax = 0;
			double discountPercent = 0;
			System.out.println("Sale  #" + s.getCodeSales());
			System.out.println("Store #" + s.getCodeStore());
			System.out.println("Customer:");
			System.out.printf("%s \n\n", s.getCustomer());
			System.out.println("Sales Person:");
			System.out.printf("%s \n\n", s.getSalesperson());
			System.out.println("Item\t\t\t\t\t\t\t\t\t\t$ Total");
			System.out.println("===================\t\t\t\t\t\t\t\t========");
			for(Item i : s.getItems()) {
				String name = i.getName();
				System.out.println(name);
				if(i.getType().equals("PU")) {
					System.out.printf("\t(Used Item #%s @$%.2f/ea)", i.getCode(), i.costUsed());
					System.out.printf("%50.2f\n", i.totalCost());
					subtotal += i.totalCost();
					tax += i.getTax();
				} else if (i.getType().equals("PN")) {
					System.out.printf("\t(New Item #%s @$%.2f/ea)", i.getCode(), i.cost());
					System.out.printf("%50.2f\n", i.totalCost());
					subtotal += i.totalCost();
					tax += i.getTax();
				} else if (i.getType().equals("SV")) {
					System.out.printf("\t(Service #%s by %s, %s %.2f@$%.2f/hr)", i.getCode(), 
										i.getLastName(), i.getFirstName(), i.getHoursWorked(), i.getHourlyRate());
					System.out.printf("%30.2f\n", i.totalCost());
					subtotal += i.totalCost();
					tax += i.getTax();
				} else if (i.getType().equals("PG")) {
					System.out.printf("\t(Gift Card #%s)", i.getCode());
					System.out.printf("%55.2f\n", i.totalCost());
					subtotal += i.totalCost();
					tax += i.getTax();
				} else if (i.getType().equals("SB")) {
					System.out.printf("\t(Subscription #%s %d days@$%.2f)", i.getCode(), i.getAge(), i.cost());
					System.out.printf("%39.2f\n", i.totalCost());
					subtotal += i.totalCost();
				}
				if(s.getCustomer().getType().equals("G")) {
					discountPercent = 0.05;
				} else if(s.getCustomer().getType().equals("P")) {
					discountPercent = .1;
				} else if(s.getCustomer().getType().equals("E")) {
					discountPercent = .15;
				}
			}
			System.out.println("\t\t\t\t\t\t\t\t\t\t===========");
			System.out.printf("\t\t\t\t\t\t\t\tSubtotal $ %15.2f\n", subtotal);
			System.out.printf("\t\t\t\t\t\t\t\t     Tax $ %15.2f\n", tax);
			if(discountPercent > 0) {
				double discount = (tax + subtotal) * discountPercent;
				System.out.printf("\t\t\t\t\t\t\t\tDiscount $ %15.2f\n", discount);
				double grandTotal = subtotal + tax - discount;
				System.out.printf("\t\t\t\t\t\t\t     Grand Total $ %15.2f\n", grandTotal);
			} else {
				double grandTotal = subtotal + tax;
				System.out.printf("\t\t\t\t\t\t\t\t\tGrand Total $ %15.2f\n", grandTotal);
			}
			System.out.println("\n\n");
			
			
		}
		
	}
	
	public static void main(String[] args) {
		List<Item> items = LoadFile.loadFileItems();
		PrintFile.printFileItemsXml(items);
		//PrintFile.printFileItemsJson(items);

		List<Person> persons = LoadFile.loadFilePersons();

		List<Store> stores = LoadFile.loadFileStores();
		PrintFile.printFilePersonsXml(persons);
		PrintFile.printFilePersonsJson(persons);
		
		List<Sale> sales = LoadFile.loadFileSales(items, persons);

		reportReceipts(sales, persons);
		// search for managers in persons and set manager for Store
		for (Store s : stores) {
			String code = s.getManagerCode();
			for (Person p : persons) {
				if (p.getCode().equals(code)) {
					s.setManager(p);
					break;
				}
			}
		}

		PrintFile.printFileStoresXml(stores);
		PrintFile.printFileStoresJson(stores);
	}

}
