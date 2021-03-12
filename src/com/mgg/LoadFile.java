package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadFile {
	/**
	 * Method returns a list of Store objects read in from a .csv file
	 * 
	 * @return
	 */
	public static List<Store> loadFileStores() {
		Scanner s = null;
		List<Store> stores = new ArrayList<>();

		try {
			s = new Scanner(new File("data/Stores.csv"));
			s.nextLine(); // skip first line since data read in does not use it

			while (s.hasNextLine()) {
				String line = s.nextLine();

				String tokens[] = line.split(",|;", -1);

				String storeCode = tokens[0];
				String managerCode = tokens[1];
				Address address = new Address(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
				Store b = new Store(storeCode, managerCode, address);
				stores.add(b);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return stores;
	}

	/**
	 * Method reads in a .csv file containing data for Items for sale in a store and
	 * returns the data as a list of 'Items' objects
	 * 
	 * @return
	 */
	public static List<Item> loadFileItems() {
		Scanner s = null;
		List<Item> items = new ArrayList<>();

		try {
			s = new Scanner(new File("data/Items.csv"));
			// skip first line
			s.nextLine();

			while (s.hasNextLine()) {
				String line = s.nextLine();

				String tokens[] = line.split(",|;", -1);

				String code = tokens[0];
				String type = tokens[1];
				String name = tokens[2];
				
				
				double price = 0;
				
				if (tokens.length > 3 && tokens[3] != null && !tokens[3].isBlank()) {
					if(tokens[1].equalsIgnoreCase("SV")) {
						price = Double.parseDouble(tokens[3]);
						Service b = new Service(code, type, name, price);
						items.add(b);
					} else if (tokens[1].equalsIgnoreCase("SB")) {
						price = Double.parseDouble(tokens[3]);
						Subscription b = new Subscription(code, type, name, price);
						items.add(b);
					} else if (tokens[1].equalsIgnoreCase("PU") || tokens[1].equalsIgnoreCase("PN")) {
						price = Double.parseDouble(tokens[3]);
						Product b = new Product(code, type, name, price);
						items.add(b);
					}
					
				} else {
					Product b = new Product(code, type, name);
					items.add(b);
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return items;
	}

	/**
	 * Method reads in data for a 'Persons' object and returns a list
	 * 
	 * @return
	 */
	public static List<Person> loadFilePersons() {
		Scanner s = null;
		List<Person> persons = new ArrayList<>();

		try {
			s = new Scanner(new File("data/Persons.csv"));
			//read in first line for number of lines
			int numLines = Integer.parseInt(s.nextLine());
			for (int i = 0; i < numLines; ++i) {
				List<String> emailAddresses = new ArrayList<>();
				String line = s.nextLine();

				String[] tokens = line.split(",|;", -1);

				String code = tokens[0];
				String type = tokens[1];
				String lastName = tokens[2];
				String firstName = tokens[3];

				for (int size = 9; size < tokens.length; size++) {
					if (!tokens[size].isEmpty())
						emailAddresses.add(tokens[size]);
				}

				Address address = new Address(tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]);
				Person b = new Person(code, type, lastName, firstName, address, emailAddresses);

				persons.add(b);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return persons;
	}
	
	public static List<Sale> loadFileSales(List<Item> listItems, List<Person> persons) {
		Scanner s = null;
		List<Sale> sales = new ArrayList<>();

		try {
			s = new Scanner(new File("data/Sales.csv"));
			//read in first line for number of lines
			int numLines = Integer.parseInt(s.nextLine());
			for (int i = 0; i < numLines; ++i) {
				List<Item> items = new ArrayList<>();
				String line = s.nextLine();

				String[] tokens = line.split(",|;", -1);

				String codeSales = tokens[0];
				String codeStore = tokens[1];
				String codeCustomer = tokens[2];
				String codeSalesperson = tokens[3];

				Person customer = null;
				Person salesperson = null;
				for(Person p : persons) {
					if(codeCustomer.equalsIgnoreCase(p.getCode()) ) {
						customer = new Person(p.getCode(), p.getType(), p.getLastName(), 
											  p.getFirstName(), p.getAddress(), p.getEmailAddresses());
					} else if (codeSalesperson.equalsIgnoreCase(p.getCode()) ) {
						salesperson = new Person(p.getCode(), p.getType(), p.getLastName(), 
											     p.getFirstName(), p.getAddress(), p.getEmailAddresses());
					}
						
				}
				
				for (int size = 4; size < tokens.length; size++) {
				
					for(Item m : listItems) {
						if (tokens[size].equalsIgnoreCase(m.getCode()) && m.getType().equalsIgnoreCase("SV")) {
							String firstName = null;
							String lastName = null;
							for(Person p : persons) {
								if(tokens[size + 1].equalsIgnoreCase(p.getCode())) {
									firstName = p.getFirstName();
									lastName = p.getLastName();
								}
							}
							Service b = new Service(m.getCode(), m.getType(), m.getName(), m.getHourlyRate(), Double.parseDouble(tokens[size + 2]), firstName, lastName);
							items.add(b);
							size = size + 2;
						} else if (tokens[size].equalsIgnoreCase(m.getCode()) && m.getType().equalsIgnoreCase("SB")) {
							Subscription b = new Subscription(m.getCode(), m.getType(), m.getName(), m.cost(), tokens[size + 1], tokens[size + 2]);
							items.add(b);
							size = size + 2;
						} else if (tokens[size].equalsIgnoreCase(m.getCode()) && m.getType().equalsIgnoreCase("PG")) {
							Item b = new Product(m.getCode(), m.getType(), m.getName(), Double.parseDouble(tokens[size + 1]));
							items.add(b);
							size++;
						} else if (tokens[size].equalsIgnoreCase(m.getCode()) && 
								  ( m.getType().equalsIgnoreCase("PN") || m.getType().equalsIgnoreCase("PU") ) ){
							Item b = new Product(m.getCode(), m.getType(), m.getName(), m.cost(), Double.parseDouble(tokens[size + 1]));
							items.add(b);
							size++;
						}
					}
					
					
				}

				Sale b = new Sale(codeSales, codeStore, customer, salesperson, items);

				sales.add(b);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		return sales;
	}

}
