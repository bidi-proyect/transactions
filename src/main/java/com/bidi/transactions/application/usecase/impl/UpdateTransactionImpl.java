package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.UpdateTransactionService;
import com.bidi.transactions.application.utils.MessageResponse;
import com.bidi.transactions.dto.UpdateTransactionRequest;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionImpl implements UpdateTransactionService {
    @Override
    public MessageResponse updateTransaction(UpdateTransactionRequest updateTransactionRequest) {
        return null;
    }
}
