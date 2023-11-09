package com.bidi.transactions.controller;

import com.bidi.transactions.dto.CreateTransactionRequest;
import com.bidi.transactions.dto.TransactionResponse;
import com.bidi.transactions.service.CreateTransactionService;
import com.bidi.transactions.service.GetTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final CreateTransactionService createTransactionService;
    private final GetTransactionService getTransactionService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<List<TransactionResponse>> getTransaction(@PathVariable String phoneNumber) {
        List<TransactionResponse> response = getTransactionService.getTransactions(phoneNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody CreateTransactionRequest createTransactionRequest) throws Exception {
        TransactionResponse response = createTransactionService.createTransaction(createTransactionRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
