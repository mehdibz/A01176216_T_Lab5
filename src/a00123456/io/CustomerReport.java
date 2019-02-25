/**
 * Project: A00123456Lab3
 * File: CustomerReport.java
 * Copyright 2017 Sam Cirka. All rights reserved.
 */

package a00123456.io;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00123456.data.Customer;
import a00123456.util.Common;

/**
 * Prints a formated Customers report.
 * 
 * @author Sam Cirka, A00123456
 *
 */
public class CustomerReport {

	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s";
	public static final String CUSTOMER_FORMAT = "%3d. %06d %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s";

	private static final Logger LOG = LogManager.getLogger();

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param customers
	 */
	public static void write(List<Customer> customers, PrintStream out) {
		LOG.debug("Creating the customer report");
		String text = null;
		println("Customers Report", out);
		println(HORIZONTAL_LINE, out);
		text = String.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone", "Email", "Join Date");
		println(text, out);
		println(HORIZONTAL_LINE, out);

		int i = 0;
		for (Customer customer : customers) {
			LocalDate date = customer.getJoinedDate();
			text = String.format(CUSTOMER_FORMAT, ++i, customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getStreet(), customer.getCity(),
					customer.getPostalCode(), customer.getPhone(), customer.getEmailAddress(), Common.DATE_FORMAT.format(date));
			println(text, out);
		}
	}

	private static void println(String text, PrintStream out) {
		out.println(text);
		LOG.debug(text);
	}
}
