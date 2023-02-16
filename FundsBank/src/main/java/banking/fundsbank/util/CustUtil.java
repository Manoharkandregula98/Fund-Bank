package banking.fundsbank.util;

import java.util.Scanner;

import banking.fundsbank.dto.Customer;

public class CustUtil {

	public static Customer createCustomer(Scanner sc, String accountType) {
		Customer cust = new Customer();
		cust.setAccountType(accountType);
		System.out.println("Enter AccNo:");
		cust.setAccNo(sc.nextLong());
		System.out.println("First Name: ");
		cust.setFirstName(sc.next());
		System.out.println("Last Name: ");
		cust.setLastName(sc.next());
		System.out.println("Age: ");
		cust.setAge(sc.nextInt());
		System.out.println("Mobile Number:");
		cust.setMobileNumber(sc.nextLong());
		System.out.println("Address: Flat Number");
		int flatNum = sc.nextInt();
		System.out.println("Area: ");
		String area = sc.next();
		System.out.println("City: ");
		String city = sc.next();
		System.out.println("State: ");
		String state = sc.next();
		System.out.println("Pincode: ");
		int pincode = sc.nextInt();
		// adding address in customer table
		cust.setAddress(flatNum + ", " + area + ", " + city + ", " + state + ", " + pincode);
		return cust;
	}

}