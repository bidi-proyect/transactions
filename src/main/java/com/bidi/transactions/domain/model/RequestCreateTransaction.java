package com.bidi.transactions.domain.model;

public record RequestCreateTransaction(
        String userId,
        long amount,
        String phoneProducer,
        String phoneReceiver
) {

}

