package com.bidi.transactions.service;

import com.bidi.transactions.dto.GetTransactionByDateRequest;
import com.bidi.transactions.dto.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetTransactionsByDate {
    List<TransactionResponse> transactionsByDate(GetTransactionByDateRequest getTransactionByDateRequest);
}
