package com.bidi.transactions.service.balance;

import com.bidi.transactions.dto.balance.UpdateProducerBalanceRequest;
import com.bidi.transactions.utils.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UpdateProducerService {
    MessageResponse updateProducerBalance(UpdateProducerBalanceRequest updateProducerBalanceRequest, String idUser);
}
