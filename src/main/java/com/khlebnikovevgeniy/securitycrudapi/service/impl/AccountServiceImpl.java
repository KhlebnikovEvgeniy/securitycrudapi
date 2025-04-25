package com.khlebnikovevgeniy.securitycrudapi.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.khlebnikovevgeniy.securitycrudapi.model.Account;
import com.khlebnikovevgeniy.securitycrudapi.model.Role;
import com.khlebnikovevgeniy.securitycrudapi.repository.AccountRepository;
import com.khlebnikovevgeniy.securitycrudapi.repository.RoleRepository;
import com.khlebnikovevgeniy.securitycrudapi.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public Account createAccount(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		account.setRoles(roles);
		return accountRepository.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

}
