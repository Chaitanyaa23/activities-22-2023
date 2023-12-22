package com.npci.LoanApplication.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_application")
public class Loan_Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long application_id;
    
    private long customer_id;
   
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Customer")
    private Customer customer;

    private long loan_id;
    
    private String status;
    
    
    
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public long getApplication_id() {
		return application_id;
	}
	public void setApplication_id(long application_id) {
		this.application_id = application_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(long loan_id) {
		this.loan_id = loan_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Loan_Application(long application_id,long customer_id, Customer customer, long loan_id, String status) {
		super();
		this.customer_id = customer_id; 
		this.application_id = application_id;
		this.customer = customer;
		this.loan_id = loan_id;
		this.status = status;
	}
	public Loan_Application() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}
