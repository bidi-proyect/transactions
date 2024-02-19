package com.bidi.transactions.domain.model;


public record RequestUpdateBalance(
        long amount,
        String phoneProducer,
        String phoneReceiver
) {}
