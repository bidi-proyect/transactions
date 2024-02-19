package com.bidi.transactions.domain.model;

import java.util.Date;

public record RequestGetTransactionByDate(
     Date initDate,
     Date finalDate,
     String userId
) {

}
