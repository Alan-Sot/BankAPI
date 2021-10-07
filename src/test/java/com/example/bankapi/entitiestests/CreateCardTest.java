package com.example.bankapi.entitiestests;

import com.example.bankapi.dto.CreateCardDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCardTest {
    CreateCardDTO createCardDTO;

    @BeforeEach
    void start(){
        createCardDTO = new CreateCardDTO(1,100);
    }

    @Test
    void getAccountId(){
        assertEquals(1, createCardDTO.getAccountId());
    }

    @Test
    void getLimit(){
        assertEquals(100, createCardDTO.getLimit());
    }

    @Test
    void setAccountId(){
        createCardDTO.setAccountId(2);
        assertEquals(2, createCardDTO.getAccountId());
    }

    @Test
    void setLimit(){
        createCardDTO.setLimit(1000);
        assertEquals(1000,createCardDTO.getLimit());
    }

    @Test
    void allArgsConstructor(){
        assertEquals(1, createCardDTO.getAccountId());
        assertEquals(1, createCardDTO.getLimit());
    }

    @Test
    void NoArgsConstructor(){
        createCardDTO = new CreateCardDTO();
        assertEquals(0, createCardDTO.getAccountId());
        assertEquals(0, createCardDTO.getLimit());
    }
}
