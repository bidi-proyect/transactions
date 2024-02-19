package com.bidi.transactions.infrastructure.rest.advice;

import com.bidi.transactions.application.exceptions.TransactionException;
import com.bidi.transactions.shared.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<MessageResponse> handlerTransactionException(TransactionException e) {
         return new ResponseEntity<>(new MessageResponse(
                 e.getCode() == null ? e.getStatusCode().toString() : String.valueOf(e.getCode()),
                 e.getMessage()),
                 e.getCode() == null ?  e.getStatusCode() : e.getCode());
    }

}
