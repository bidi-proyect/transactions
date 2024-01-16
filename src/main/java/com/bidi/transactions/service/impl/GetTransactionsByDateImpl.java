package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.GetTransactionByDateRequest;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.entity.Transaction;
import com.bidi.transactions.repository.TransactionRepository;
import com.bidi.transactions.service.GetTransactionsByDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bidi.transactions.utils.TransactionMapper.transactionToResponse;
import static com.bidi.transactions.utils.Util.generateReference;

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
