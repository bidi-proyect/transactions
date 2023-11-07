package com.bidi.transactions.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "amount")
    private String amount;
    @Column(name = "phone_producer")
    private String phoneProducer;
    @Column(name = "phone_receiver")
    private String phoneReceiver;
    @Column(name = "transaction_date")
    private String transactionDate;
    @Column(name = "ref_transaction")
    private String refTransaction;
}
