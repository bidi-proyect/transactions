package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.UpdateBalanceService;
import com.bidi.transactions.domain.model.RequestUpdateBalance;
import com.bidi.transactions.shared.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class UpdateBalanceImpl implements UpdateBalanceService {
    @Override
    public MessageResponse updateBalance(String token, RequestUpdateBalance updateBalanceRequest) {

        return null;
    }
}
