package com.example.bankapi.service.card;

import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.CreateCardDTO;
import com.example.bankapi.model.Account;
import com.example.bankapi.model.Card;
import com.example.bankapi.repository.account.AccountRepositoryImpl;
import com.example.bankapi.repository.card.CardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CardServiceImpl implements CardService{

    private final CardRepositoryImpl cardRepository;
    private final AccountRepositoryImpl accountRepository;

    @Autowired
    public CardServiceImpl(CardRepositoryImpl cardRepository, AccountRepositoryImpl accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<List<CardDTO>> getAllCards(int accountId) {
        if (accountId <= 0){
            throw new IllegalArgumentException();
        }
        List<Card> cards = cardRepository.getAllCards(accountId);
        if (cards == null || cards.isEmpty()){
            throw new IllegalArgumentException();
        }
        List<CardDTO> cardDTOList = new ArrayList<>();
        for (Card card : cards){
            cardDTOList.add(cardToDTO(card));
        }
        return new ResponseEntity<>(cardDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CardDTO> createCard(CreateCardDTO createCardDTO) {
        if (createCardDTO.getLimit() < 0){
            throw new IllegalArgumentException();
        }
        Account account = accountRepository.getAccountById(createCardDTO.getAccountId());
        if (account == null){
            throw new IllegalArgumentException();
        }
        Card card = new Card();
        card.withAccount(account);
        card.withLimit(createCardDTO.getLimit());
        Random random = new Random();
        String randomNumber;
        do {
            randomNumber = Long.toString(random.nextLong()).substring(1, 17);
        }while (cardRepository.containsCard(randomNumber));
        card.setCardNumber(randomNumber);
        cardRepository.saveCard(card);
        CardDTO cardDTO = cardToDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }

    @Override
    public String cardNumberBuilder(String string) {
        return new StringBuilder(string).insert(4, " ").insert(9, " ").insert(14, " ").toString();
    }

    @Override
    public CardDTO cardToDTO(Card card) {
        return new CardDTO(card.getLimit(), cardNumberBuilder(card.getCardNumber()));
    }
}
