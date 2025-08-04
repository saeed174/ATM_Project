package com.sfs.Services;

import com.sfs.Repository.AccountRepository;
import com.sfs.entity.Account;

public class AccountService {
    private AccountRepository AccountRepository = new AccountRepository();
    public Account search(String cardNumber) {
        if(cardNumber.charAt(0) == '0')
            return AccountRepository.getWalletAccount(cardNumber);
        else
            return AccountRepository.getBankAccount(Long.parseLong(cardNumber));
    }

    public void save(Account bankAccount) {
        try {
            AccountRepository.save(bankAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(Account bankAccount) {
        try {
            AccountRepository.update(bankAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Account bankAccount) {
        try {
            AccountRepository.remove(bankAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        AccountRepository.close();
    }
}
