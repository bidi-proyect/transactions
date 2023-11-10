package com.bidi.transactions.service;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public interface CreateTransactionService {
    TransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest) throws Exception;
}
