package com.java.dao;

import java.util.Collection;

import com.java.dto.Account;
import com.java.exception.InvalidAccountException;

public interface AccountRepository {

	void openAccount(Account account);

	void closeAccount(int accountNumber);

	void updateAccount(Account account) throws InvalidAccountException;

	Account getAccountByNumber(int accountNumber);

	Collection<Account> getAccounts();

}