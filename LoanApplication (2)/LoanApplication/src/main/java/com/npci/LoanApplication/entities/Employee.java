package com.npci.LoanApplication.entities;

import java.awt.PageAttributes.MediaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id //
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long EmployeeId;
	
	@Column(name = "employee_name")
	private String EmployeeName;
	
	@Column(name = "email_id")
	private String EmailId;
	
	@Column(name = "password")
	private String Password;

	public long getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(long employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Employee(int employeeId, String employeeName, String emailId, String password) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		EmailId = emailId;
		Password = password;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
