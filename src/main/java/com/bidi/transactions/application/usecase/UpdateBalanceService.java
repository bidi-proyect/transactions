package com.bidi.transactions.application.usecase;

import com.bidi.transactions.application.utils.MessageResponse;
import com.bidi.transactions.dto.UpdateBalanceRequest;
import org.springframework.stereotype.Service;

@Service
public interface UpdateBalanceService {
    MessageResponse updateBalance (String token, UpdateBalanceRequest updateBalanceRequest);
}
