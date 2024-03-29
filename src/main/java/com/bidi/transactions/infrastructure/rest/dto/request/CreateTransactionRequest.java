package com.bidi.transactions.infrastructure.rest.dto.request;

public record CreateTransactionRequest(
        String userId,
        long amount,
        String phoneProducer,
        String phoneReceiver
) {

}

