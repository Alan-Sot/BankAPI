package com.example.bankapi.repository.account;

import com.example.bankapi.model.Account;

import java.util.List;

public interface AccountRepository {
    Account saveAccount(Account account);
    Account getAccountById(int id);
}
