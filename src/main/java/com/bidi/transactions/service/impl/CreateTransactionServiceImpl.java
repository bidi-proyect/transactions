package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.dto.UpdateBalanceRequest;
import com.bidi.transactions.entity.Transaction;
import com.bidi.transactions.repository.TransactionRepository;
import com.bidi.transactions.service.CreateTransactionService;
import com.bidi.transactions.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreateTransactionServiceImpl implements CreateTransactionService {

    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LoggerFactory.getLogger(CreateTransactionServiceImpl.class);
    @Value("${balance.url.base}")
    private String urlBase;
    @Value("${balance.url.one}")
    private String createPath;

    @Override
    public TransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest) {
        logger.info("Request is made...");

        try {
            ResponseEntity<MessageResponse> response = makeRestToBalanceService(createTransactionRequest);
            logger.info("BalanceService response: {}", Objects.requireNonNull(response.getBody()).getMessage());
            return transactionToResponse(setAndSaveTransaction(createTransactionRequest, "Approved", setDescription(response.getStatusCodeValue())));
        }catch (HttpClientErrorException | HttpServerErrorException e) {
            String error = extractRestResponse(Objects.requireNonNull(e.getMessage()));
            logger.error("Error: {}", error);
            return transactionToResponse(setAndSaveTransaction(createTransactionRequest, "Cancelled.", error));
        }
    }

    public ResponseEntity<MessageResponse> makeRestToBalanceService(CreateTransactionRequest createTransactionRequest) {
        String url = urlBase + createPath + createTransactionRequest.getUserId();
        return this.restTemplate.exchange(url, HttpMethod.PUT, setHttpEntity(createTransactionRequest), MessageResponse.class);
    }

    public HttpEntity<UpdateBalanceRequest> setHttpEntity(CreateTransactionRequest createTransactionRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(constructBalanceRequest(createTransactionRequest), headers);
    }

    public UpdateBalanceRequest constructBalanceRequest(CreateTransactionRequest createTransactionRequest) {
        UpdateBalanceRequest request = new UpdateBalanceRequest();
        request.setAmount(createTransactionRequest.getAmount());
        request.setPhoneProducer(createTransactionRequest.getPhoneProducer());
        request.setPhoneReceiver(createTransactionRequest.getPhoneReceiver());
        return request;
    }

    public String extractRestResponse(String input) {
        return input.substring(input.indexOf("message") + 9, input.length() - 2).replace("\"", "");
    }

    public String setDescription(int statusCode) {
        return statusCode == 200 ? "Transaction successfully." : "Error.";
    }

    public TransactionResponse transactionToResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setUserId(transaction.getUserId());
        response.setAmount(transaction.getAmount());
        response.setPhoneProducer(transaction.getPhoneProducer());
        response.setPhoneReceiver(transaction.getPhoneReceiver());
        response.setTransactionDate(transaction.getTransactionDate());
        response.setRefTransaction(transaction.getRefTransaction());
        response.setStatus(transaction.getStatus());
        response.setDescription(transaction.getDescription());
        return response;
    }

    public Transaction setAndSaveTransaction(CreateTransactionRequest createTransactionRequest, String status, String description) {
        Transaction transaction = requestToTransaction(createTransactionRequest);
        transaction.setAmount(status.equals("Cancelled") ? 0 : createTransactionRequest.getAmount());
        transaction.setStatus(status);
        transaction.setDescription(description);
        transactionRepository.save(transaction);
        return transaction;
    }

    public Transaction requestToTransaction(CreateTransactionRequest createTransactionRequest) {
        Transaction transaction = new Transaction();
        transaction.setUserId(createTransactionRequest.getUserId());
        transaction.setPhoneProducer(createTransactionRequest.getPhoneProducer());
        transaction.setPhoneReceiver(createTransactionRequest.getPhoneReceiver());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setRefTransaction(generateReference());
        return transaction;
    }

    public String generateReference() {
        return String.valueOf(new Random().nextInt(99999999 - 10000000 + 1) + 10000000);
    }
}
