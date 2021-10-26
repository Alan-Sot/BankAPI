package com.example.bankapi.repository.card;

import com.example.bankapi.model.Card;

import java.util.List;

public interface CardRepository {
    List<Card> getAllCards(int accountId);
    Card saveCard(Card card);
    boolean containsCard(String number);
}
