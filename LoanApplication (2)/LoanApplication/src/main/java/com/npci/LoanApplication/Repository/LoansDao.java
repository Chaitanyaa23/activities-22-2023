package com.npci.LoanApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.LoanApplication.entities.Loan;

public interface LoansDao extends JpaRepository<Loan, Integer>{

}
