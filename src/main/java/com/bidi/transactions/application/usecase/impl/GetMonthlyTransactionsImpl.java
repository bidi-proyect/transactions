package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.GetMonthlyTransactions;
import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMonthlyTransactionsImpl implements GetMonthlyTransactions {
    @Override
    public List<TransactionResponse> monthlyTransaction(String userId) {

        return null;
    }
}
