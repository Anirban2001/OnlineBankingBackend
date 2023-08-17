package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	private AccountRepository accountRepository;
	
	
	
	public AccountController(AccountRepository accountRepository) {
//		super();
		this.accountRepository = accountRepository;
	}



	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account)
	{
		Account i = accountRepository.save(account);
		return new ResponseEntity<Account>(i,HttpStatus.CREATED);
	}
	
	@GetMapping("/{accountNo}")
	public ResponseEntity<Optional<Account>> findAccountByAccountNo(@PathVariable("accountNo") long accountNo) {

		Optional<Account> inOptional=accountRepository.findByAccountNo(accountNo);
		System.out.println(inOptional);
		return ResponseEntity.ok(inOptional);
	}
	

}