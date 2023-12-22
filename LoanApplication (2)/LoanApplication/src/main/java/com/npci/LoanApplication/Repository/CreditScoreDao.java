package com.npci.LoanApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.LoanApplication.entities.CreditScore;

public interface CreditScoreDao extends JpaRepository<CreditScore, String>{

}
