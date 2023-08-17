package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	private TransactionRepository transactionRepository;
	
	
	
	public TransactionController(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}



	@PostMapping
	public ResponseEntity<Transaction> createLogin(@RequestBody Transaction transaction)
	{
		Transaction i = transactionRepository.save(transaction);
		return new ResponseEntity<Transaction>(i,  HttpStatus.CREATED);
	}

}