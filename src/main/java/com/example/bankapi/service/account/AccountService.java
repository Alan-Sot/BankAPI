package com.example.bankapi.service.account;

import com.example.bankapi.dto.MaxBalanceDTO;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<Long> getBalanceByAccount(int accountId);
    ResponseEntity<Long> maxUpBalance(MaxBalanceDTO maxBalanceDTO);
}
