package com.bidi.transactions.infrastructure.rest.dto.request;

import java.util.Date;

public record GetTransactionByDateRequest(
     Date initDate,
     Date finalDate,
     String userId
) {

}
