package banking.fundsbank;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import banking.fundsbank.dto.Customer;
import banking.fundsbank.service.FundsBankService;
import banking.fundsbank.service.FundsBankServiceImple;
import banking.fundsbank.util.CustUtil;
import banking.fundsbank.util.MenuDisplay;

public class FundsBankMain {
	private FundsBankService fbService;

	public FundsBankMain() {
		fbService = new FundsBankServiceImple();
	}

	private void execute() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (true) {
			choice = MenuDisplay.getChoice(sc);
			switch (choice) {
			case 1:
				System.out.println("Create A Customer");
				Customer cust = null;
				String accountType = null;
				do {
					do {
						System.out.println("Select account type: ");
						accountType = MenuDisplay.getAccountType(sc);
					} while (accountType == null);
					try {
						cust = CustUtil.createCustomer(sc, accountType);
						boolean success = fbService.createCustomer(cust);
						if (success)
							System.out.println("Customer Created Sucessfully...!");
						else
							System.out.println("Failed.. Customer Not created..!");
					} catch (InputMismatchException e) {
						System.out.println("Please enter the details correctly..!");
						sc.nextLine();
					}
				} while (cust == null);

				break;
			case 2:
				System.out.println("Display the Customer");
				List<Customer> custList = fbService.getCustomers();
				System.out.println(custList);
				break;
			case 3:
				System.out.println("Exit Bank! Thank you banking with us..");
				fbService.closeConnection();
				System.out.println("Connection closed..!");
				System.out.println("System exited.. Thank you!");
				System.exit(0);
				break;

			default:
				if (choice < 0)
					System.out.println("Negative Selection not allowed");
				System.out.println("Please seclect Choice from 1 to 3 only");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new FundsBankMain().execute();
	}

}
