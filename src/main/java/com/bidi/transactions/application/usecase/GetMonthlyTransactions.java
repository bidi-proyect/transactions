package com.bidi.transactions.application.usecase;

import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetMonthlyTransactions {
    List<TransactionResponse> monthlyTransaction(String userId);
}
