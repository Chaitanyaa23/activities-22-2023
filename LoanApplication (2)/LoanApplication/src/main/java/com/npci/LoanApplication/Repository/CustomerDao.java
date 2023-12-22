package com.npci.LoanApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.LoanApplication.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	@Query("select cust from Customer cust where cust.email_id=?1")
	public List<Customer> getByMailId(String mailId);
}
