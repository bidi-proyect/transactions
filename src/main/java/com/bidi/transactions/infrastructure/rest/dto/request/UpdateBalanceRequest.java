package com.bidi.transactions.infrastructure.rest.dto.request;


public record UpdateBalanceRequest(
        long amount,
        String phoneProducer,
        String phoneReceiver
) {}
