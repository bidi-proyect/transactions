package com.bidi.transactions.application.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<MessageResponse> handlerTransactionException(TransactionException e) {
         return new ResponseEntity<>(new MessageResponse(e.getMessage()), e.getCode());
    }
}
