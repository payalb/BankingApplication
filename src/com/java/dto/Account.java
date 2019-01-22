package com.java.dto;

import java.util.ArrayList;
import java.util.List;

import com.java.exception.InvalidAmountException;
import com.java.service.AccountService;
import com.java.service.AccountServiceImpl;

import lombok.Data;

@Data

public class Account {
	{
		count++;
		accountNumber = count;
	}
	private static int count;
	private int accountNumber;
	private List<Customer> customers = new ArrayList<>();
	private String bank = "MyBank";
	private double balance;
	static AccountService service = new AccountServiceImpl();

	public Account(List<Customer> customerList, double balance) throws CloneNotSupportedException, InvalidAmountException {
		for (Customer c : customerList) {
			customers.add((Customer) c.clone());
		}
		if(balance<0) {
			throw new InvalidAmountException("Invalid amount passed"+ balance);
		}
		this.balance = balance;
	}

	public boolean depositMoney(double amount) throws InvalidAmountException {
		if (amount > 0) {
			balance += amount;
			return true;
		} else {
			throw new InvalidAmountException("Invalid amount, cannot deposit " + amount);
		}
	}

	public boolean withdrawMoney(double amount) throws InvalidAmountException {
		boolean isSuccess = false;
		if (amount > 0 && balance > amount) {
			balance -= amount;
			isSuccess = true;
			return isSuccess;
		} else {
			isSuccess = false;
			throw new InvalidAmountException("Invalid amount, cannot withdraw " + amount);
		}

	}

	public void transferMoney(double amount, int fromAccount, int toAccount) throws InvalidAmountException {
		if (withdrawMoney(amount, fromAccount)) {
			try {
				depositMoney(amount, toAccount);
			} catch (InvalidAmountException e) {
				depositMoney(amount, fromAccount);// compensatory action
			}
		}
	}

	private static boolean depositMoney(double amount, int toAccount) throws InvalidAmountException {
		Account account = service.getAccountByNumber(toAccount);
		return account.depositMoney(amount);

	}

	private static boolean withdrawMoney(double amount, int fromAccount) throws InvalidAmountException {
		Account account = service.getAccountByNumber(fromAccount);
		return account.withdrawMoney(amount);
	}

}
