package com.example.bankapi.repository.card;

import com.example.bankapi.model.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Card> getAllCards(int accountId) {
        return entityManager.createQuery("SELECT Card FROM Card card WHERE card.account.id =: accountId", Card.class)
                .setParameter("accountId", accountId).getResultList();
    }

    @Override
    public Card saveCard(Card card) {
        if (entityManager.contains(card)) {
            return entityManager.merge(card);
        }else {
            entityManager.persist(card);
            return card;
        }
    }

    @Override
    public boolean containsCard(String number) {
        Card card;
        try {
            card = entityManager.createQuery("SELECT Card FROM Card card WHERE card.cardNumber =: cardNumber", Card.class)
                    .setParameter("cardNumber", number).getSingleResult();
        } catch (Exception e){
            card = null;
        }
        return card != null;
    }
}
