package com.bidi.transactions.application.usecase;

import com.bidi.transactions.domain.model.ResponseTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetMonthlyTransactions {
    List<ResponseTransaction> monthlyTransaction(String userId);
}
