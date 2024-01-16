package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.entity.Transaction;
import com.bidi.transactions.repository.TransactionRepository;
import com.bidi.transactions.rest.BalanceRest;
import com.bidi.transactions.service.CreateTransactionService;
import com.bidi.transactions.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import java.util.Objects;
import java.util.Random;

import static com.bidi.transactions.utils.StringConstants.*;
import static com.bidi.transactions.utils.TransactionMapper.requestToTransaction;
import static com.bidi.transactions.utils.TransactionMapper.transactionToResponse;
import static com.bidi.transactions.utils.Util.extractRestResponse;
import static com.bidi.transactions.utils.Util.generateReference;

@Service
@RequiredArgsConstructor
public class CreateTransactionServiceImpl implements CreateTransactionService {

    private final TransactionRepository transactionRepository;
    private final Random random = new Random();
    private final BalanceRest balanceRest;
    private static final Logger logger = LoggerFactory.getLogger(CreateTransactionServiceImpl.class);

    @Override
    public TransactionResponse createTransaction(
            CreateTransactionRequest createTransactionRequest,
            String token) {
        logger.info("Request is made...");
        try {
            ResponseEntity<MessageResponse> response = balanceRest.makeRestToBalanceService(createTransactionRequest, token);
            String statusCode = setDescription(response.getStatusCode().value());
            Transaction transaction = setAndSaveTransaction(createTransactionRequest, APPROVED, statusCode);
            logger.info("BalanceService response: {}", Objects.requireNonNull(response.getBody()).getMessage());
            return transactionToResponse(transaction, generateReference());
        }catch (HttpClientErrorException | HttpServerErrorException e) {
            String error = extractRestResponse(Objects.requireNonNull(e.getMessage()));
            logger.error("Error: {}", error);
            return transactionToResponse(setAndSaveTransaction(createTransactionRequest, CANCELLED, error), generateReference());
        }
    }

    public String setDescription(int statusCode) {
        return statusCode == 200 ? SUCCESSFULLY : ERROR;
    }

    public Transaction setAndSaveTransaction(
            CreateTransactionRequest createTransactionRequest,
            String status, String description) {
        Transaction transaction = requestToTransaction(createTransactionRequest, generateReference());
        transaction.setAmount(status.equals("Cancelled") ? 0 : createTransactionRequest.getAmount());
        transaction.setStatus(status);
        transaction.setDescription(description);
        transactionRepository.save(transaction);
        return transaction;
    }
}
