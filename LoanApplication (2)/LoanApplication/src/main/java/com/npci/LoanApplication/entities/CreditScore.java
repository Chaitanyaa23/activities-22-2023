package com.npci.LoanApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Credit_Score")
public class CreditScore {

    @Id
    private String pan; // PAN serves as the primary key

    private int score;

    // Default constructor
    public CreditScore() {
    }

    // Parameterized constructor
    public CreditScore(String pan, int score) {
        this.pan = pan;
        this.score = score;
    }

    // Getter and Setter for PAN
    public String getPan() {
        return pan;
    }

    // Note: No setter for PAN to make it read-only in this example.

    // Getter and Setter for score
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
