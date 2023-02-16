package com.fundsbank;

import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

import com.fundsbank.dto.Customer;
import com.fundsbank.service.BankingService;
import com.fundsbank.service.BankingServiceImpl;
import com.fundsbank.util.MenuDisplay;
public class FundsBankMain {
	private BankingService bService;
	
	public static void main(String[] args) {
		new FundsBankMain().execute();
	}
	public FundsBankMain() {
		bService = new BankingServiceImpl();
	}
	private void execute(){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(true) {
			choice = MenuDisplay.getChoice(sc);
			switch(choice) {
			case 1:
				System.out.println("Create a customer");
				Customer cust = null;
				System.out.println("ENTER<firstName><lastName><Mobile><address><adhaarNo>");
				try {
				cust = new Customer();
				boolean success = bService.createCustomer(cust);
				if(success) {
					System.out.println("Customer created successfully");
				} else {
					System.out.println("Failes to create a customer");
				}
				}catch(InputMismatchException e) {
					System.out.println("Please enter the details correctly..");
					sc.nextLine();
				}while(cust==null);
				break;
			
			case 2:
				System.out.println("Display the Customer");
				List<Customer>custList= bService.getCustomers();
				System.out.println(custList);
				break;
			case 3:
				System.out.println("Exit Bank!Thank you");
				System.exit(0);
				break;
			default:
				if(choice<0)
					System.out.println("Negative selection not allowed");
				System.out.println("Please select choice from 1 to 3 nly");
				break;
			}
		}
	}

}