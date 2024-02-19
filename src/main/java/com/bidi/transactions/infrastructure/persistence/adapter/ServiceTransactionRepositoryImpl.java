package com.bidi.transactions.infrastructure.persistence.adapter;

import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.domain.model.RequestCreateTransaction;
import com.bidi.transactions.domain.service.ServiceTransactionRepository;
import com.bidi.transactions.infrastructure.persistence.entity.Transaction;
import com.bidi.transactions.infrastructure.persistence.mapper.TransactionDaoMapper;
import com.bidi.transactions.infrastructure.persistence.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.bidi.transactions.application.utils.Util.generateReference;

@Service
@RequiredArgsConstructor
@Lazy
public class ServiceTransactionRepositoryImpl implements ServiceTransactionRepository {

    private final TransactionRepository transactionRepository;
    private final TransactionDaoMapper transactionDaoMapper;

    @Override
    public TransactionDao save(RequestCreateTransaction request,
                               String status, String description) {
        Transaction transaction = new Transaction();
        transaction.setUserId(request.userId());
        transaction.setAmount(status.equals("Cancelled") ? 0 : request.amount());
        transaction.setPhoneProducer(request.phoneProducer());
        transaction.setPhoneReceiver(request.phoneReceiver());
        transaction.setTransactionDate(new Date());
        transaction.setRefTransaction(generateReference());
        transaction.setStatus(status);
        transaction.setDescription(description);
        transactionRepository.save(transaction);
        return transactionDaoMapper.transactionToTransactionDao(transaction);
    }

    @Override
    public List<TransactionDao> findTransactionByPhoneProducer(String phoneProducer) {
        List<Transaction> transactions = transactionRepository.findTransactionByPhoneProducer(phoneProducer);
        return transactions.stream()
                .map(transactionDaoMapper::transactionToTransactionDao)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDao> monthlyTransactions(Date initDate, Date finalDate, String userId) {
        List<Transaction> transactions = transactionRepository.monthlyTransactions(initDate, finalDate, userId);
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() > 0)
                .map(transactionDaoMapper::transactionToTransactionDao).toList();
    }
}
