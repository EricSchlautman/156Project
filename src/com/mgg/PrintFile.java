package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

public class PrintFile {
	/**
	 * Method prints out an XML file from a given list of Store objects
	 * 
	 * @param b
	 */
	public static void printFileStoresXml(List<Store> b) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Stores.xml"));
			p.println("<Stores>");
			for (Store s : b) {
				XStream xstream = new XStream();
				xstream.alias("store", Store.class);
				String xmlStore = xstream.toXML(s);
				p.println(xmlStore);
			}
			p.println("</Stores>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Method prints out a JSON file from a given list of Store objects
	 * 
	 * @param b
	 */
	public static void printFileStoresJson(List<Store> b) {
		int i = 0;
		try {
			PrintWriter p = new PrintWriter(new File("data/Stores.json"));
			p.println("{");
			p.println("\"Stores\": [");
			for (Store s : b) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String jsonStore = gson.toJson(s);
				p.println(jsonStore);
				i += 1;
				if (i == b.size() - 1) {
					break;
				}
				p.printf(",\n");
			}
			p.println("]}");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Method outputs data to a file in .xml format of 'Items' objects
	 * 
	 * @param b
	 */
	public static void printFileItemsXml(List<Item> i) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Items.xml"));
			p.println("<Items>");
			for (Item j : i) {
				XStream xstream = new XStream();
				xstream.alias("items", Item.class);
				String xmlItems = xstream.toXML(j);
				p.println(xmlItems);
			}
			p.println("</Items>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Method prints out a JSON file from a given list of 'Items' objects
	 * 
	 * @param i
	 */
	public static void printFileItemsJson(List<Item> i) {
		int iterations = 0;
		try {
			PrintWriter p = new PrintWriter(new File("data/Items.json"));
			p.println("{");
			p.println("\"Items\": [");
			for (Item j : i) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String jsonItem = gson.toJson(j);
				p.println(jsonItem);
				iterations += 1;
				if (iterations == i.size() - 1) {
					break;
				}
				p.printf(",\n");
			}
			p.println("]}");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Method outputs a file in .xml format containing data for 'Persons' objects
	 * 
	 * @param ps
	 */
	public static void printFilePersonsXml(List<Person> ps) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Persons.xml"));
			p.println("<Persons>");
			for (Person o : ps) {
				XStream xstream = new XStream();
				xstream.alias("Person", Person.class);
				String xmlPerson = xstream.toXML(o);
				p.println(xmlPerson);
			}
			p.println("</Persons>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method prints out a JSON file from a given list of 'Persons' objects
	 * 
	 * @param ps
	 */
	public static void printFilePersonsJson(List<Person> ps) {
		int i = 0;
		try {
			PrintWriter p = new PrintWriter(new File("data/Persons.json"));
			p.println("{");
			p.println("\"Persons\": [");
			for (Person o : ps) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String jsonPerson = gson.toJson(o);
				p.printf(jsonPerson);
				i += 1;
				if (i == ps.size()) {
					break;
				}
				p.printf(",\n");
			}
			p.println("]}");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
