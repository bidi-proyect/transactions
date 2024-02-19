package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.GetTransactionService;
import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.domain.mapper.TransactionDtoMapper;
import com.bidi.transactions.domain.model.ResponseTransaction;
import com.bidi.transactions.domain.service.ServiceTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bidi.transactions.application.utils.Util.generateReference;

@Service
@RequiredArgsConstructor
public class GetTransactionImpl implements GetTransactionService {

    private final ServiceTransactionRepository transactionRepository;
    private final TransactionDtoMapper transactionDtoMapper;
    @Override
    public List<ResponseTransaction> getTransactions(String phoneNumber) {
        List<TransactionDao> transactionList = transactionRepository.findTransactionByPhoneProducer(phoneNumber);
        return transactionList.stream().map(transactionDtoMapper::daoToResponseDto).toList();
    }
}
