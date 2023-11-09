package com.bidi.transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBalanceRequest {

    private long amount;

    private String phoneProducer;

    private String phoneReceiver;

}
