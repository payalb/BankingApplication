package com.java.service;

import java.util.Collection;

import com.java.dto.Account;
import com.java.exception.InvalidAccountException;

public interface AccountService {
	void openAccount(Account account);

	void closeAccount(int accountNumber);

	void updateAccount(Account account) throws InvalidAccountException;

	Account getAccountByNumber(int accountNumber);

	Collection<Account> getAccounts();
}
