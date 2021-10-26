package com.example.bankapi.rest;

import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.CreateCardDTO;
import com.example.bankapi.dto.MaxBalanceDTO;
import com.example.bankapi.service.account.AccountServiceImpl;
import com.example.bankapi.service.card.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final AccountServiceImpl accountService;
    private final CardServiceImpl cardService;

    @Autowired
    public RestController(AccountServiceImpl accountService, CardServiceImpl cardService) {
        this.accountService = accountService;
        this.cardService = cardService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Long> getBalance(@PathVariable int accountId){
        return accountService.getBalanceByAccount(accountId);
    }

    @GetMapping("/{accountId}/cards")
    public ResponseEntity<List<CardDTO>> getAllCards(@PathVariable int accountId){
        return cardService.getAllCards(accountId);
    }

    @PostMapping("/newCard")
    public ResponseEntity<CardDTO> createCard(@RequestBody CreateCardDTO createCardDTO){
        return cardService.createCard(createCardDTO);
    }

    @PatchMapping("/maxUp")
    public ResponseEntity<Long> addBalance(@RequestBody MaxBalanceDTO maxBalanceDTO){
        return accountService.maxUpBalance(maxBalanceDTO);
    }
}
