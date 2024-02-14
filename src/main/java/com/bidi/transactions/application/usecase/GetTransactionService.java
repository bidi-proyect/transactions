package com.bidi.transactions.application.usecase;

import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetTransactionService {
    List<TransactionResponse> getTransactions(String phoneNumber);
}
