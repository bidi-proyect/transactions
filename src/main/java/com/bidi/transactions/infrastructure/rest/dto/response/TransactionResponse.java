package com.bidi.transactions.infrastructure.rest.dto.response;

import java.util.Date;
public record TransactionResponse(
        String userId,
        long amount,
        String phoneProducer,
        String phoneReceiver,
        Date transactionDate,
        String refTransaction,
        String status,
        String description
) {}
