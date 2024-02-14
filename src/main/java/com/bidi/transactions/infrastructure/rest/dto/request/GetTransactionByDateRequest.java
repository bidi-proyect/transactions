package com.bidi.transactions.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetTransactionByDateRequest {
    private Date initDate;
    private Date finalDate;
    private String userId;
}
