package com.khlebnikovevgeniy.securitycrudapi.resource;

import static com.khlebnikovevgeniy.securitycrudapi.resource.EmployeeResource.getLocation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khlebnikovevgeniy.securitycrudapi.model.Account;
import com.khlebnikovevgeniy.securitycrudapi.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountResource {
	private final AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account newAccount = accountService.createAccount(account);
		return ResponseEntity.created(getLocation(newAccount.getId().intValue())).body(newAccount);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAccount() {
		return ResponseEntity.ok(accountService.getAccounts());
	}

}
