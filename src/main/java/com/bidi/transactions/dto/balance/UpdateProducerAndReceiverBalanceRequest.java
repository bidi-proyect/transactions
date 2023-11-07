package com.bidi.transactions.dto.balance;

import lombok.Data;

@Data
public class UpdateProducerAndReceiverBalanceRequest {
    private long amount;
    private String phoneProducer;
    private String phoneReceiver;
}
