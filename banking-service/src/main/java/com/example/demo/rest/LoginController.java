package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;

@RestController
@RequestMapping("/logins")
public class LoginController {
	private LoginRepository loginRepository;
	
	//constructor injection 
	// right click ->source->generate constructor using field ->enter
	public LoginController(LoginRepository loginRepository) {
//		super();
		this.loginRepository = loginRepository;

	}
	
	@PostMapping
	public ResponseEntity<Login> createLogin(@RequestBody Login login) {
		Login i = loginRepository.save(login);
		return new ResponseEntity<Login>(i, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Optional<Login>> findLoginByUserId(@PathVariable("userId") String userId) {

		Optional<Login> inOptional=loginRepository.findByUserId(userId);
		System.out.println(inOptional);
		return ResponseEntity.ok(inOptional);
	}
	
	@PutMapping("/{userId}")
    public ResponseEntity<Login> updateLogin(@PathVariable("userId") String userId, @RequestBody Login updatedLogin) {
        Optional<Login> existingLoginOptional = loginRepository.findByUserId(userId);
        if (existingLoginOptional.isPresent()) {
            Login existingLogin = existingLoginOptional.get();
            existingLogin.setPassword(updatedLogin.getPassword());
            existingLogin.setAdmin(updatedLogin.getAdmin());
            existingLogin.setEmail(updatedLogin.getEmail());

            Login updated = loginRepository.save(existingLogin);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteLogin(@PathVariable("userId") String userId) {
        Optional<Login> loginOptional = loginRepository.findByUserId(userId);
        if (loginOptional.isPresent()) {
            loginRepository.delete(loginOptional.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}