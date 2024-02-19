package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.UpdateTransactionService;
import com.bidi.transactions.domain.model.RequestUpdateTransaction;
import com.bidi.transactions.shared.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class UpdateTransactionImpl implements UpdateTransactionService {
    @Override
    public MessageResponse updateTransaction(RequestUpdateTransaction updateTransactionRequest) {
        return null;
    }
}
