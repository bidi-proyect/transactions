package com.bidi.transactions.entity;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Cache;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "AMOOUNT")
    private String amount;
    @Column(name = "DESTINATION")
    private String destination;
    @Column(name = "TRANSACTION_DATE")
    private String transactionDate;
    @Column(name = "REF_TRANSACTION")
    private String redTransaction;
}
