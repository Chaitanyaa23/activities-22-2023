package com.npci.LoanApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_id;

    private String loan_type;

	public long getLoan_id() {
		return loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public Loan(long loan_id, String loan_type) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
	}
    
	public Loan() {
		super();
	}
}
