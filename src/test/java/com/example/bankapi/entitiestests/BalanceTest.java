package com.example.bankapi.entitiestests;

import com.example.bankapi.dto.MaxBalanceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceTest {

    MaxBalanceDTO maxBalanceDTO;

    @BeforeEach
    void start(){
        maxBalanceDTO = new MaxBalanceDTO(1,100);
    }

    @Test
    void getAccountId(){
        assertEquals(1,maxBalanceDTO.getAccountId());
    }

    @Test
    void getAmount(){
        assertEquals(10, maxBalanceDTO.getAmount());
    }

    @Test
    void setAccountId(){
        maxBalanceDTO.setAccountId(1);
        assertEquals(1, maxBalanceDTO.getAccountId());
    }

    @Test
    void setAmount(){
        maxBalanceDTO.setAmount(100);
        assertEquals(100, maxBalanceDTO.getAmount());
    }

    @Test
    void allArgsConstructor(){
        assertEquals(1, maxBalanceDTO.getAccountId());
        assertEquals(10, maxBalanceDTO.getAmount());
    }

    @Test
    void noArgsConstructor(){
        maxBalanceDTO = new MaxBalanceDTO();
        assertEquals(0, maxBalanceDTO.getAccountId());
        assertEquals(0, maxBalanceDTO.getAmount());
    }
}
