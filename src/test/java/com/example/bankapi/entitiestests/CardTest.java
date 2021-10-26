package com.example.bankapi.entitiestests;

import com.example.bankapi.dto.CardDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardTest {
    CardDTO cardDTO;

    @BeforeEach
    void start(){
        cardDTO = new CardDTO(1000, "0982374659871098");
    }

    @Test
    void getLimit(){
        assertEquals(100,cardDTO.getLimit());
    }

    @Test
    void getCardNumber(){
        assertEquals("0982374659871098", cardDTO.getCardNumber());
    }

    @Test
    void setLimit(){
        cardDTO.setLimit(200);
        assertEquals(200, cardDTO.getLimit());
    }

    @Test
    void setCardNumber(){
        cardDTO.setCardNumber("9875438754023111");
        assertEquals("9875438754023111", cardDTO.getCardNumber());
    }

    @Test
    void allArgsConstructor(){
        assertEquals("0982374659871098", cardDTO.getCardNumber());
        assertEquals(200, cardDTO.getLimit());
    }

    @Test
    void noArgsConstructor(){
        cardDTO = new CardDTO();
        assertEquals(0, cardDTO.getLimit());
        assertNull(cardDTO.getCardNumber());
    }
}
