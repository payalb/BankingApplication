package com.java.client;

import java.util.Arrays;
import java.util.Scanner;

import com.java.dto.Account;
import com.java.dto.Customer;
import com.java.exception.InvalidAmountException;

public class Client {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Client client = new Client();
		while (true) {
			client.displayMainMenu();
		}
		/*
		 * Customer customerA= Customer.builder() .firstName("Payal")
		 * .phoneNumber(436747435l).build();
		 * 
		 * try { Account account1= new Account(Arrays.asList(customerA), 500); } catch
		 * (CloneNotSupportedException e) {
		 * System.out.println("Database problem! Try after some time"); } catch
		 * (InvalidAmountException e) { e.printStackTrace(); }
		 */

	}

	private  void displayMainMenu() {
		System.out.println("Choose from an option. Press (a/b/c)");
		System.out.println("a: Manage Account");
		System.out.println("b: Manage Customer");
		System.out.println("c: Exit");
		String input = scanner.nextLine();

		switch (input) {
		case "A":
		case "a":
			showOptionsForAccount();
			break;
		case "B":
		case "b":
			showOptionsForCustomer();
			break;
		case "c":
		case "C":
			System.out.println("Thanks for your visit");
			System.exit(0);
		default:
			System.out.println("Choose a valid option");
		}
	}

	private void showOptionsForCustomer() {
		// TODO Auto-generated method stub

	}

	private void showOptionsForAccount() {
		System.out.println("Account options: Press (a/b/c/d/e): ");
		System.out.println("a: Open an account");
		System.out.println("b: Close an account");
		System.out.println("c: Update account");
		System.out.println("d: View account details");
		System.out.println("e: View all accounts");
		System.out.println("f: Go to your main menu");
		String input = scanner.nextLine();
		switch (input) {
		case "a":
			boolean flag = true;

			System.out.println("Enter the customer first name");
			String c1firstName = scanner.nextLine();
			System.out.println("Enter the customer last name");
			String c1lastName = scanner.nextLine();
			System.out.println("Enter phoneNumber:");
			long c1PhoneNo = Long.parseLong(scanner.nextLine());
			// email id. address
			while (flag) {
				System.out.println("Enter initial blance");
				double startingBalance = Double.parseDouble(scanner.nextLine());
				Customer c1 = Customer.builder().firstName(c1firstName).lastName(c1lastName).phoneNumber(c1PhoneNo)
						.build();
				// joint account
				try {
					Account account = new Account(Arrays.asList(c1), startingBalance);
					flag = false;
				} catch (CloneNotSupportedException e) {
					System.out.println(" Site currently under mantainance. Try again after sometime" + e.getMessage());
				} catch (InvalidAmountException e) {
					System.out.println("Please enter a valid amount:");
				}
				
			}
			System.out.println("Account created successfully");
			break;
		}
		displayMainMenu();
	}
}
