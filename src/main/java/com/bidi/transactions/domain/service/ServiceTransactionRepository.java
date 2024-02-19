package com.bidi.transactions.domain.service;

import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.domain.model.RequestCreateTransaction;

import java.util.Date;
import java.util.List;

public interface ServiceTransactionRepository {
    TransactionDao save(RequestCreateTransaction requestCreateTransaction,
                        String status, String description);
    List<TransactionDao> findTransactionByPhoneProducer(String phoneProducer);
    List<TransactionDao> monthlyTransactions(Date initDate, Date finalDate, String userId);
}
