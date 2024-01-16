package com.bidi.transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private String userId;
    private long amount;
    private String phoneProducer;
    private String phoneReceiver;
    private Date transactionDate;
    private String refTransaction;
    private String status;
    private String description;
}
