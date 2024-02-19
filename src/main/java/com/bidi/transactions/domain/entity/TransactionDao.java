package com.bidi.transactions.domain.entity;

import java.util.Date;

public record TransactionDao (
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
