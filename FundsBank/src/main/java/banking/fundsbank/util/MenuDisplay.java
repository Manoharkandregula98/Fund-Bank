package banking.fundsbank.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDisplay {

	public static int getChoice(Scanner sc) {
		int choice = 0;
		System.out.println("** Welcome to Funds Bank ** ");
		System.out.println("1. Create Customer");
		System.out.println("2. Display Customer");
		System.out.println("3. Exit Bank");
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please Enter valid numbers Only..!");
			sc.nextLine(); // Consume Keyboard vaule or else it will loop infinitely
			//After consuming choice will return 0, because we write it in default.
		}
		return choice;
	}

	public static String getAccountType(Scanner sc) {
		int choice = 0;
		String accountype = null;
		System.out.println("1. Current Account");
		System.out.println("2. Savings Account");
		choice = sc.nextInt(); 
		try {
			switch (choice) {
			case 1:
				accountype = "Current Account";
				break;
			case 2:
				accountype = "Savings Account";
				break;

			default:
				if (choice < 0)
					System.out.println("Negative Selection not allowed");
				System.out.println("Please seclect Choice from 1 to 2 only");
				break;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please Enter valid numbers Only..!");
			sc.nextLine();
		}
		return accountype;
	}

}
