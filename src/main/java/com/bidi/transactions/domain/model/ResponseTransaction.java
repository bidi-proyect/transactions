package com.bidi.transactions.domain.model;

import java.util.Date;
public record ResponseTransaction(
        long idTransaction,
        String userId,
        long amount,
        String phoneProducer,
        String phoneReceiver,
        Date transactionDate,
        String refTransaction,
        String status,
        String description
) {}
