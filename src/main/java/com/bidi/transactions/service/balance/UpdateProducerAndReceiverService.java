package com.bidi.transactions.service.balance;

import com.bidi.transactions.dto.balance.UpdateProducerAndReceiverBalanceRequest;
import com.bidi.transactions.utils.MessageResponse;

public interface UpdateProducerAndReceiverService {
    MessageResponse updateProducerAndReceiverBalance(UpdateProducerAndReceiverBalanceRequest updateProducerAndReceiverBalanceRequest, String idUser);
}
