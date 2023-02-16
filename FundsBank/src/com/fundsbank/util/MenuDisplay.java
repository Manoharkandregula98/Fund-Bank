package com.fundsbank.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDisplay {
	public static int getChoice(Scanner sc) {
		int choice = 0;
		System.out.println("**Banking System:");
		System.out.println("1 Create customer");
		System.out.println("2 Display Customer");
		System.out.println("3 Exit Bank");
		try {
		choice  = sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Please enter numbers only");
		sc.nextLine();}
		return choice;
		
	}

}
