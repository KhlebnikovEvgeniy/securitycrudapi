package com.khlebnikovevgeniy.securitycrudapi.service;

import java.util.List;

import com.khlebnikovevgeniy.securitycrudapi.model.Account;

public interface AccountService {
	Account createAccount(Account account);
	Account findByUsername(String username);
	List<Account> getAccounts();
}
