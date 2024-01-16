package com.bidi.transactions.utils;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.entity.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class TransactionMapper {
    public static Transaction requestToTransaction(
            CreateTransactionRequest createTransactionRequest,
            String reference) {
        return Transaction.builder()
                .userId(createTransactionRequest.getUserId())
                .phoneProducer(createTransactionRequest.getPhoneProducer())
                .phoneReceiver(createTransactionRequest.getPhoneReceiver())
                .transactionDate(new Date())
                .refTransaction(reference)
                .build();
    }
    public static TransactionResponse transactionToResponse(Transaction transaction, String reference) {
        return TransactionResponse.builder()
                .userId(transaction.getUserId())
                .amount(transaction.getAmount())
                .phoneProducer(transaction.getPhoneProducer())
                .phoneReceiver(transaction.getPhoneReceiver())
                .transactionDate(transaction.getTransactionDate())
                .refTransaction(reference)
                .status(transaction.getStatus())
                .description(transaction.getDescription())
                .build();
    }
}
