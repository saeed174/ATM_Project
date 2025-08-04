package com.sfs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount implements Account {
    @Id
    private long cardNumber;
    private String cardHolderName;
    private double balance;
    private String password;
    public BankAccount() {}
    public BankAccount(long cardNumber, String cardHolderName, double balance, String password) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.balance = balance;
        this.password = password;
    }

    @Override
    public void addBalance(double amount) {
        balance += amount;
    }

    @Override
    public void withdrawBalance(double amount) throws IllegalArgumentException{
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountHolderName() {
        return cardHolderName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

}
