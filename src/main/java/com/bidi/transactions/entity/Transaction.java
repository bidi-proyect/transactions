package com.bidi.transactions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "amount")
    private long amount;

    @Column(name = "phone_producer")
    private String phoneProducer;

    @Column(name = "phone_receiver")
    private String phoneReceiver;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "ref_transaction", unique = true)
    private String refTransaction;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
}
