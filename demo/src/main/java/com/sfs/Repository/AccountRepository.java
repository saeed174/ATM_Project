package com.sfs.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sfs.entity.Account;
import com.sfs.entity.BankAccount;
import com.sfs.entity.WalletAccount;

public class AccountRepository {
    private SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.sfs.entity.BankAccount.class)
                            .addAnnotatedClass(com.sfs.entity.WalletAccount.class)
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();

    private Session sc = sf.openSession();

    public BankAccount getBankAccount(long cardNumber) {
        return sc.get(com.sfs.entity.BankAccount.class, cardNumber);
    }

    public WalletAccount getWalletAccount(String cardNumber) {
        return sc.get(com.sfs.entity.WalletAccount.class, cardNumber);
    }

    public void save(Account bankAccount) {
        try {
            sc.beginTransaction();
            sc.persist(bankAccount);
            sc.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Account bankAccount) {
        try {
            sc.beginTransaction();
            sc.merge(bankAccount);
            sc.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Account bankAccount) {
        try {
            sc.beginTransaction();
            sc.remove(bankAccount);
            sc.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        sc.close();
        sf.close();
    }
}

