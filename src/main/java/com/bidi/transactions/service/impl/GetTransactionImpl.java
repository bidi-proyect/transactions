package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.entity.Transaction;
import com.bidi.transactions.repository.TransactionRepository;
import com.bidi.transactions.service.GetTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bidi.transactions.utils.TransactionMapper.transactionToResponse;
import static com.bidi.transactions.utils.Util.generateReference;

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
