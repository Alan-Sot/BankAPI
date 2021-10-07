package com.example.bankapi.service.account;

import com.example.bankapi.dto.MaxBalanceDTO;
import com.example.bankapi.model.Account;
import com.example.bankapi.repository.account.AccountRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    private final AccountRepositoryImpl accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<Long> getBalanceByAccount(int accountId) {
        if (accountId <= 0) {
            throw new IllegalArgumentException();
        }
        Account account = accountRepository.getAccountById(accountId);
        if (account == null){
            throw new IllegalArgumentException();
        }
        return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> maxUpBalance(MaxBalanceDTO maxBalanceDTO) {
        if (maxBalanceDTO.getAmount() <= 0){
            throw new IllegalArgumentException();
        }
        Account account = accountRepository.getAccountById(maxBalanceDTO.getAccountId());
        if (account == null){
            throw new IllegalArgumentException();
        }
        account.setBalance(account.getBalance() + maxBalanceDTO.getAmount());
        Long result = accountRepository.saveAccount(account).getBalance();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
