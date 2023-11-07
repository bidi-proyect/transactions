package com.bidi.transactions.service.balance;

import com.bidi.transactions.dto.balance.CreateBalanceRequest;
import com.bidi.transactions.utils.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface CreateBalanceService {
    MessageResponse createBalance(CreateBalanceRequest createBalanceRequest);

}
