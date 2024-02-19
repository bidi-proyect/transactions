package com.bidi.transactions.domain.port;

import com.bidi.transactions.infrastructure.rest.dto.request.CreateTransactionRequest;
import com.bidi.transactions.shared.MessageResponse;

public interface BalanceRest {
    MessageResponse makeRestToBalanceService(CreateTransactionRequest request,
                                             String token);
}
