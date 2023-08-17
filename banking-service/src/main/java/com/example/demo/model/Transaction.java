package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import org.hibernate.annotations.Columns;


@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Transaction {
	@Id
	@Column(name="transaction_id")
	private long transactionId;
	@Column(name="to_acc_no")
	private long toAccNo;
	@Column(name="from_acc_no")
	private long fromAccNo;
	@Column(name="amount")
	private long amount;
	@Column(name="date")
	private String date;
	@Column(name="remarks")
	private String remarks;
	@Column(name="mode")
	private String mode;
//	@Override
//	public String toString() {
//		return "Transaction [transactionId=" + transactionId + ", toAccNo=" + toAccNo + ", fromAccNo=" + fromAccNo
//				+ ", amount=" + amount + ", date=" + date + ", remarks=" + remarks + ", mode=" + mode + "]";
//	}
	


	


//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "from_acc_no")
//	private Account account;
//	
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "to_acc_no")
//	private Payee payee;
}