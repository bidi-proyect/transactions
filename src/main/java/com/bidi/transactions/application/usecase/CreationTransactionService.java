package com.bidi.transactions.application.usecase;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public interface CreationTransactionService {
    TransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest, String token);
}
