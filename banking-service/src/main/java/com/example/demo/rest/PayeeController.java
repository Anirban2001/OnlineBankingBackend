package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payee;
import com.example.demo.repository.PayeeRepository;

@RestController
@RequestMapping("/payees")
public class PayeeController {
	private PayeeRepository payeeRepository;
	
	
	
	public PayeeController(PayeeRepository payeeRepository) {
		super();
		this.payeeRepository = payeeRepository;
	}



	@PostMapping
	public ResponseEntity<Payee> createPayee(@RequestBody Payee payee)
	{
		Payee i = payeeRepository.save(payee);
		return new ResponseEntity<Payee>(i,HttpStatus.CREATED);
	}

}