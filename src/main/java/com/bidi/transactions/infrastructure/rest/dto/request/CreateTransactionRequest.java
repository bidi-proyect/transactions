package com.bidi.transactions.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {

    private String userId;

    private long amount;

    private String phoneProducer;

    private String phoneReceiver;


}
