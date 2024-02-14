package com.bidi.transactions.application.usecase.impl;

import com.bidi.transactions.application.usecase.UpdateBalanceService;
import com.bidi.transactions.application.utils.MessageResponse;
import com.bidi.transactions.dto.UpdateBalanceRequest;
import org.springframework.stereotype.Service;

@Service
public class UpdateBalanceImpl implements UpdateBalanceService {
    @Override
    public MessageResponse updateBalance(String token, UpdateBalanceRequest updateBalanceRequest) {

        return null;
    }
}
