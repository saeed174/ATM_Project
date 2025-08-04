package com.sfs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WalletAccount implements Account{
    @Id
    private String phoneNumber;
    private String walletHolderName;
    private double balance;
    private String password;
    public WalletAccount(String phoneNumber, String walletHolderName, double balance, String password) {
        this.phoneNumber = phoneNumber;
        this.walletHolderName = walletHolderName;
        this.balance = balance;
        this.password = password;
    }

    public WalletAccount() {}

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
        return walletHolderName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWalletHolderName() {
        return walletHolderName;
    }

    
    
}
