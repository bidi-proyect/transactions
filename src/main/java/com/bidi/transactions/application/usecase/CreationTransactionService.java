package com.bidi.transactions.application.usecase;

import com.bidi.transactions.domain.model.RequestCreateTransaction;
import com.bidi.transactions.domain.model.ResponseTransaction;
import org.springframework.stereotype.Service;

@Service
public interface CreationTransactionService {
    ResponseTransaction createTransaction(RequestCreateTransaction requestCreateTransaction, String token);
}
