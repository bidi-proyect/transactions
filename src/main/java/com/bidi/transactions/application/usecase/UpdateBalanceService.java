package com.bidi.transactions.application.usecase;

import com.bidi.transactions.domain.model.RequestUpdateBalance;
import com.bidi.transactions.shared.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateBalanceService {
    MessageResponse updateBalance (String token, RequestUpdateBalance updateBalanceRequest);
}
