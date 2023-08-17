package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

//import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
//@Data

public class Account {
	@Id
	@Column(name="account_no", nullable=false)
	private long accountNo;
	@Column(name="title", nullable = false)
	private String title;
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="middle_name")
	private String middleName;
	@Column(name="last_name", nullable=false)
	private String lastName;
	@Column(name="father_name", nullable=false)
	private String fathersName;
	@Column(name="mobile_number", nullable=false)
	private long mobileNumber;
	@Column(name="aadhar_number", nullable=false)
	private long aadharNumber;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="dob", nullable=false)
	private String dob;
	@Column(name="transaction_pin")
	private int transactionPin;
	@Column(name="balance", nullable=false)
	private long balance;
	@Column(name="occupation_type", nullable=false)
	private String occupationType;
	@Column (name="source_of_income", nullable=false)
	private String sourceOfIncome;
	@Column(name="annual_income", nullable=false)
	private long annualIncome;
	@Column(name="account_type", nullable=false)
	private String accountType;
	@Column(name="permanent_address")
	private String permanentAddress;
	@Column(name = "residensial_address")
	private String residensialAddress;
	
	
	
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", title=" + title + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", fathersName=" + fathersName + ", mobileNumber="
				+ mobileNumber + ", aadharNumber=" + aadharNumber + ", dob=" + dob + ", transactionPin="
				+ transactionPin + ", balance=" + balance + ", occupationType=" + occupationType + ", sourceOfIncome="
				+ sourceOfIncome + ", annualIncome=" + annualIncome + ", accountType=" + accountType
				+ ", permanentAddress=" + permanentAddress + ", residensialAddress=" + residensialAddress + "]";
	}

	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Login login;



	
	

//    @OneToOne(mappedBy="account", cascade = CascadeType.ALL)
//    private Transaction transaction;
	
//	@JsonManagedReference
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Payee> payee;
	
}