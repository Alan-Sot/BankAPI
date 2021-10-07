package com.example.bankapi.repository.account;

import com.example.bankapi.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account saveAccount(Account account) {
        if (entityManager.contains(account)) {
            return entityManager.merge(account);
        }else {
            entityManager.persist(account);
            return account;
        }
    }

    @Override
    public Account getAccountById(int id) {
        return entityManager.find(Account.class, id);
    }
}
