package com.bidi.transactions.service.impl;

import com.bidi.transactions.dto.UpdateBalanceRequest;
import com.bidi.transactions.service.UpdateBalanceService;
import com.bidi.transactions.utils.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class UpdateBalanceImpl implements UpdateBalanceService {
    @Override
    public MessageResponse updateBalance(String token, UpdateBalanceRequest updateBalanceRequest) {

        return null;
    }
}
