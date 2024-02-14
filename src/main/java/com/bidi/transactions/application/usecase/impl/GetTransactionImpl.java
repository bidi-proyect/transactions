package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.GetTransactionService;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.infrastructure.persistence.entity.Transaction;
import com.bidi.transactions.infrastructure.persistence.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bidi.transactions.application.utils.TransactionMapper.transactionToResponse;
import static com.bidi.transactions.application.utils.Util.generateReference;

@Service
@RequiredArgsConstructor
public class GetTransactionImpl implements GetTransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public List<TransactionResponse> getTransactions(String phoneNumber) {
        List<Transaction> transactionList = transactionRepository.findTransactionByPhoneProducer(phoneNumber);
        return transactionList.stream().map(transaction -> transactionToResponse(transaction, generateReference())).toList();
    }
}
