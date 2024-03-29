package com.bidi.transactions.application.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor
@Setter
@Getter
public class TransactionException extends RuntimeException{
    private String message;
    private HttpStatus code;
    private HttpStatusCode statusCode;

    public TransactionException(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    public TransactionException(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
