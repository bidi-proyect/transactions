package com.bidi.transactions.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
