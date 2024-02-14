package com.bidi.transactions.application.usecase;

import com.bidi.transactions.application.utils.MessageResponse;
import com.bidi.transactions.dto.UpdateTransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface UpdateTransactionService {
    MessageResponse updateTransaction (UpdateTransactionRequest updateTransactionRequest);
}
