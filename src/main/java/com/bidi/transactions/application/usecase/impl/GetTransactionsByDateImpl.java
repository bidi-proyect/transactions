package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.GetTransactionsByDate;
import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.domain.model.RequestGetTransactionByDate;
import com.bidi.transactions.domain.model.ResponseTransaction;
import com.bidi.transactions.domain.service.ServiceTransactionRepository;
import com.bidi.transactions.domain.mapper.TransactionDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTransactionsByDateImpl implements GetTransactionsByDate {

    private final ServiceTransactionRepository transactionRepository;
    private final TransactionDtoMapper transactionDtoMapper;

    @Override
    public List<ResponseTransaction> transactionsByDate(RequestGetTransactionByDate request) {
        List<TransactionDao> transactions = transactionRepository.monthlyTransactions(request.initDate(), request.finalDate(), request.userId());
        return transactions.stream()
                .map(transactionDtoMapper::daoToResponseDto)
                .toList();
    }
}
