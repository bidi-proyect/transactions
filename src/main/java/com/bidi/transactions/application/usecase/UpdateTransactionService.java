package com.bidi.transactions.application.usecase;

import com.bidi.transactions.domain.model.RequestUpdateTransaction;
import com.bidi.transactions.shared.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateTransactionService {
    MessageResponse updateTransaction (RequestUpdateTransaction updateTransactionRequest);
}
