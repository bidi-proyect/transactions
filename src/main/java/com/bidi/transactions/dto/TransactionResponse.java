package com.bidi.transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private String userId;

    private long amount;

    private String phoneProducer;

    private String phoneReceiver;

    private LocalDateTime transactionDate;

    private String refTransaction;

    private String status;

    private String description;
}
