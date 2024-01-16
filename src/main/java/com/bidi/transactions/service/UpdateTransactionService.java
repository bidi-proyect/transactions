package com.bidi.transactions.service;

import com.bidi.transactions.dto.UpdateTransactionRequest;
import com.bidi.transactions.utils.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateTransactionService {
    MessageResponse updateTransaction (UpdateTransactionRequest updateTransactionRequest);
}
