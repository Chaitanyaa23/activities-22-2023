package com.npci.LoanApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.LoanApplication.Repository.LoansDao;
import com.npci.LoanApplication.entities.Loan;


@RestController
@RequestMapping("/Loan")
public class Loans {
	
	@Autowired
	LoansDao loanDao;

	@GetMapping("/AllLoans")
	public ResponseEntity<List<Loan>> getLoans(){
		return ResponseEntity.status(200).body(loanDao.findAll());
	}
	
	@PostMapping("/NewLoan")
	public ResponseEntity<String> setNewLoan(@RequestBody Loan loan){
		loanDao.save(loan);
		return ResponseEntity.status(200).body("New Loan Entered");
	}
	
//	@PostMapping("/ApplyLoan")
//	public ResponseEntity<String> ApplyLoan()
}
