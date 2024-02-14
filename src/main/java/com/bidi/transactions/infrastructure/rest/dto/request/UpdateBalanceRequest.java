package com.bidi.transactions.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBalanceRequest {

    private long amount;

    private String phoneProducer;

    private String phoneReceiver;

}
