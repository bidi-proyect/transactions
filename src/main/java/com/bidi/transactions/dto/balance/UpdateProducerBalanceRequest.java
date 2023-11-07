package com.bidi.transactions.dto.balance;

import lombok.Data;

@Data
public class UpdateProducerBalanceRequest {
    private long amount;
    private String phoneProducer;
    private int action;
}
