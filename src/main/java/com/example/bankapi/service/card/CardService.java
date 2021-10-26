package com.example.bankapi.service.card;

import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.CreateCardDTO;
import com.example.bankapi.model.Card;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {
    ResponseEntity<List<CardDTO>> getAllCards(int accountId);
    ResponseEntity<CardDTO> createCard(CreateCardDTO createCardDTO);
    String cardNumberBuilder(String string);
    CardDTO cardToDTO(Card card);
}
