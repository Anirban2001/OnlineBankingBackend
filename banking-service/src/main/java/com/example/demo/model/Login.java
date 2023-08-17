package com.example.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "login")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@Data
public class Login {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "isadmin")
    private int admin;
    @Column(name = "email")
    private String email;
    
    
    
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", password=" + password + ", admin=" + admin + ", email=" + email + "]";
	}

  //Without this override it can't fetch the proper data, it will create conflict during get method
	
    
  
	
	//Without this it will not map properly it will store null value
    @JsonManagedReference
    @OneToMany(mappedBy = "login", cascade = CascadeType.ALL)
    private List<Account> account;
    
    
    
}