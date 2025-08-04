package com.sfs.entity;

public interface Account {
    void addBalance(double amount);
    void withdrawBalance(double amount);
    double getBalance();
    String getAccountHolderName();
    String getPassword();
}
