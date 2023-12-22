package com.npci.LoanApplication.Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.LoanApplication.Repository.CreditScoreDao;
import com.npci.LoanApplication.Repository.CustomerDao;
import com.npci.LoanApplication.entities.CreditScore;
import com.npci.LoanApplication.entities.Customer;
import com.npci.LoanApplication.entities.login;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class Login {
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CreditScoreDao creditDao;
	
    public static boolean isValidEmail(String email) {
        // Define a simple pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }
    
    public static boolean isValidPassword(String password) {
        // Define a pattern for strong password validation
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(passwordRegex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(password);

        // Return true if the password matches the pattern, false otherwise
        return matcher.matches();
    }
	

    @PostMapping("/RegisterCustomer")
	public ResponseEntity<String> Registration(@RequestBody Customer customer) {
    	System.out.println(customer.toString());
    	
		if(customer.getFirstname().length() < 3 
				||	customer.getLastname().length() < 1 
				|| !isValidEmail(customer.getEmail_id())
				|| customer.getPan().equalsIgnoreCase("")
				|| !isValidPassword(customer.getPassword())
				|| customer.getPhone().length()!=10) {
			
			return ResponseEntity.status(200).body("Please check the below validation and retry again for Registartion"
					+ "Firstname: Minimum 3 characters\r\n"
					+ "Lastname: Minimum 1 character\r\n"
					+ "Email Id: Valid email id with . and @\r\n"
					+ "Password: Strong passwords with atleast 8 characters having 1 digit, 1 uppercase, 1 lowercase & special characters mandatorily\r\n"
					+ "Pan: Required\r\n"
					+ "Phone: 10 digits phone number\r\n"
					+ "");	
		}
		customerDao.save(customer);
		creditDao.save(new CreditScore(customer.getPan(),100));
		return ResponseEntity.status(200).body("SuccessFully Registered ");
	}
   
    
	@PostMapping("login")
	public ResponseEntity<String> LoginCheck(@RequestBody login data){
		System.out.println(data.getEmail());
		List<Customer> customerList = customerDao.getByMailId(data.getEmail());
		System.out.println(customerList.size());
		if(customerList.size() == 1) {
			if(customerList.get(0).getPassword().equals(data.getPassword())) {
				return ResponseEntity.status(200).body("Logged In Successfully");
			}
			return ResponseEntity.status(200).body("Password is wrong!! Retry!!");
		}
		return ResponseEntity.status(200).body("check Mail Id and Password");
	}
	
}
