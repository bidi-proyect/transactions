package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.entity.Transaction;
import com.bidi.transactions.repository.TransactionRepository;
import com.bidi.transactions.service.GetTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetTransactionImpl implements GetTransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public List<TransactionResponse> getTransactions(String phoneNumber) {
        List<Transaction> transactionList = transactionRepository.findTransactionByPhoneProducer(phoneNumber);
        return transactionToResponse(transactionList);
    }

    public List<TransactionResponse> transactionToResponse(List<Transaction> transactionList) {
        return transactionList.stream().map(transaction -> {
            TransactionResponse response = new TransactionResponse();
            response.setUserId(transaction.getUserId());
            response.setAmount(transaction.getAmount());
            response.setPhoneProducer(transaction.getPhoneProducer());
            response.setPhoneReceiver(transaction.getPhoneReceiver());
            response.setTransactionDate(transaction.getTransactionDate());
            response.setRefTransaction(transaction.getRefTransaction());
            response.setStatus(transaction.getStatus());
            response.setDescription(transaction.getDescription());
            return response;
        }).collect(Collectors.toList());
    }
}
