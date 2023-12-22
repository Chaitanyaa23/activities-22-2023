package com.npci.LoanApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    private String firstname;
    private String lastname;
    private String email_id;
    private String password;
    private String phone;
    private String pan;

    // Default constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String firstname, String lastname, String email_id, String password, String phone, String pan) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email_id = email_id;
        this.password = password;
        this.phone = phone;
        this.pan = pan;
    }

    // Getter and Setter for customer_id
    public long getCustomer_id() {
        return customer_id;
    }

    // Note: No setter for customer_id to make it read-only in this example.

    // Getter and Setter for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter and Setter for lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter and Setter for email_id
    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter for pan
    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }
}
