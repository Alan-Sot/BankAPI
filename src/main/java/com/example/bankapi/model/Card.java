package com.example.bankapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CARD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "spending_limit")
    private long limit;

    public void withAccount(Account account){
        this.account = account;
    }

    public void withLimit(long limit){
        this.limit = limit;
    }
}
