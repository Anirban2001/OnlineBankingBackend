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

@Entity
@Table(name = "payee")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Payee {
	@Id
	@Column( name="payee_account_no")
	private long payeeAccountNo;
	@Column( name="payee_name")
	private String payeeName;
	@Column(name="nickname")
	private String nickname;
	
//	@Override
//	public String toString() {
//		return "Payee [payeeAccountNo=" + payeeAccountNo + ", payeeName=" + payeeName + ", nickname=" + nickname + "]";
//	}
	
//	@JsonBackReference
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "parent_account_no")
//	private Account account;
	
//	 @OneToOne(mappedBy="payee", cascade = CascadeType.ALL)
//	 private Transaction transaction;
}