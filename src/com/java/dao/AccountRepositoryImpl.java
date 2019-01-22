package com.java.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.java.dto.Account;
import com.java.exception.InvalidAccountException;

//CRUD: create, readAll , readById, update, delete
public class AccountRepositoryImpl implements AccountRepository {

	static Map<Integer, Account> accounts = new HashMap<>();

	@Override
	public void openAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
	}

	@Override
	public void closeAccount(int accountNumber) {
		accounts.remove(accountNumber);
	}

	@Override
	public void updateAccount(Account account) throws InvalidAccountException {
		int accountNumber = account.getAccountNumber();
		if (accounts.containsKey(accountNumber)) {
			accounts.put(accountNumber, account);
		}else {
			throw new InvalidAccountException("Account does not exist with account Nmber"+ accountNumber);
		}
	}
	
	@Override
	public Account getAccountByNumber(int accountNumber) {
		return accounts.get(accountNumber);
	}

	@Override
	public Collection<Account> getAccounts(){
		return accounts.values();
	}
}
