package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.service.GetMonthlyTransactions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMonthlyTransactionsImpl implements GetMonthlyTransactions {
    @Override
    public List<TransactionResponse> monthlyTransaction(String userId) {

        return null;
    }
}
