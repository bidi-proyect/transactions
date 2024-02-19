package com.bidi.transactions.infrastructure.rest.controller;

import com.bidi.transactions.application.usecase.CreationTransactionService;
import com.bidi.transactions.application.usecase.GetMonthlyTransactions;
import com.bidi.transactions.application.usecase.GetTransactionService;
import com.bidi.transactions.application.usecase.GetTransactionsByDate;
import com.bidi.transactions.application.usecase.UpdateBalanceService;
import com.bidi.transactions.application.usecase.UpdateTransactionService;
import com.bidi.transactions.infrastructure.rest.dto.request.CreateTransactionRequest;
import com.bidi.transactions.infrastructure.rest.dto.request.GetTransactionByDateRequest;
import com.bidi.transactions.infrastructure.rest.dto.response.TransactionResponse;
import com.bidi.transactions.infrastructure.rest.mapper.TransactionModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
@CrossOrigin("*")
public class TransactionController {

    private final GetTransactionService getTransactionService;
    public final GetTransactionsByDate getTransactionsByDate;
    private final GetMonthlyTransactions getMonthlyTransactions;
    private final CreationTransactionService createTransactionService;
    private final UpdateTransactionService updateTransactionService;
    private final UpdateBalanceService updateBalanceService;

    private final TransactionModelMapper transactionModelMapper;

    @GetMapping("/all/{phoneNumber}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponse> getTransaction(
            @RequestHeader("Authorization") String token,
            @PathVariable String phoneNumber) {

        return transactionModelMapper.responseDomainToInfrastructure(getTransactionService.getTransactions(phoneNumber));
    }

    @GetMapping("/month/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponse> getMonthlyTransactions(
            @RequestHeader("Authorization") String token,
            @PathVariable String userId) {

        return transactionModelMapper.responseDomainToInfrastructure(getMonthlyTransactions.monthlyTransaction(userId));
    }

    @PostMapping("/byDate")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResponse> transactionsByDate(
            @RequestHeader("Authorization") String token,
            @RequestBody GetTransactionByDateRequest request) {

        return transactionModelMapper.responseDomainToInfrastructure(
                getTransactionsByDate.transactionsByDate(
                        transactionModelMapper.requestInfrastructureToRequestDomain(request)
                ));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponse createTransaction(
            @RequestHeader("Authorization") String token,
            @RequestBody CreateTransactionRequest request) {

        return transactionModelMapper.responseDomainToInfrastructure(
                createTransactionService.createTransaction(
                        transactionModelMapper.requestInfrastructureToRequestDomain(request),
                        token
                ));
    }
}
