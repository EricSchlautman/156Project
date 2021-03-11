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
	
	
	
	public static void main(String[] args) {
		List<Item> items = LoadFile.loadFileItems();
		PrintFile.printFileItemsXml(items);
		PrintFile.printFileItemsJson(items);

		List<Person> persons = LoadFile.loadFilePersons();

		List<Store> stores = LoadFile.loadFileStores();
		PrintFile.printFilePersonsXml(persons);
		PrintFile.printFilePersonsJson(persons);

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
