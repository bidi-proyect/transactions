package com.bidi.transactions.service;

import com.bidi.transactions.dto.UpdateBalanceRequest;
import com.bidi.transactions.utils.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateBalanceService {
    MessageResponse updateBalance (String token, UpdateBalanceRequest updateBalanceRequest);
}
