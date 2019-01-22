package com.java.service;

import java.util.Collection;

import com.java.dao.AccountRepository;
import com.java.dao.AccountRepositoryImpl;
import com.java.dto.Account;
import com.java.exception.InvalidAccountException;

public class AccountServiceImpl implements AccountService {

	static AccountRepository rep = new AccountRepositoryImpl();

	@Override
	public void openAccount(Account account) {
		rep.openAccount(account);
	}

	@Override
	public void closeAccount(int accountNumber) {
		rep.closeAccount(accountNumber);

	}

	@Override
	public void updateAccount(Account account) throws InvalidAccountException {
		rep.updateAccount(account);

	}

	@Override
	public Account getAccountByNumber(int accountNumber) {
		return rep.getAccountByNumber(accountNumber);
	}

	@Override
	public Collection<Account> getAccounts() {
		return rep.getAccounts();
	}

}
