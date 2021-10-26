package com.example.bankapi.entitiestests;

import com.example.bankapi.dto.AccountDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

    AccountDTO accountDTO;

    @BeforeEach
    public void start(){
        accountDTO = new AccountDTO(1, "AAAA",100);
    }

    @Test
    void getId(){
        assertEquals(1, accountDTO.getId());
    }

    @Test
    void getUserName(){
        assertEquals("AAAA", accountDTO.getUserName());
    }

    @Test
    void getBalance(){
        assertEquals(10, accountDTO.getBalance());
    }

    @Test
    void setId(){
        accountDTO.setId(10);
        assertEquals(10, accountDTO.getId());
    }

    @Test
    void setUserName(){
        accountDTO.setUserName("AAAA");
        assertEquals("AAAA", accountDTO.getUserName());
    }

    @Test
    void setBalance(){
        accountDTO.setBalance(100);
        assertEquals(100, accountDTO.getBalance());
    }

    @Test
    void allArgsConstructor(){
        assertEquals(1, accountDTO.getId());
        assertEquals(10, accountDTO.getBalance());
        assertEquals("AAAA", accountDTO.getUserName());
    }

    @Test
    void noArgsConstructor(){
        accountDTO = new AccountDTO();
        assertEquals(0, accountDTO.getId());
        assertEquals(0, accountDTO.getBalance());
        assertNull(accountDTO.getUserName());
    }

}
