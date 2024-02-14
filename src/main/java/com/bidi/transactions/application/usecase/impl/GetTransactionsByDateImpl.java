package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.GetTransactionsByDate;
import com.bidi.transactions.dto.GetTransactionByDateRequest;
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
public class GetTransactionsByDateImpl implements GetTransactionsByDate {
    private final TransactionRepository transactionRepository;
    @Override
    public List<TransactionResponse> transactionsByDate(GetTransactionByDateRequest getTransactionByDateRequest) {
        List<Transaction> transactionList = transactionRepository.monthlyTransactions(
                getTransactionByDateRequest.getInitDate(),
                getTransactionByDateRequest.getFinalDate(),
                getTransactionByDateRequest.getUserId());
        return transactionList.stream()
                .map(transaction -> transactionToResponse(transaction, generateReference()))
                .filter(transaction -> transaction.getAmount() > 0).toList();
    }
}
