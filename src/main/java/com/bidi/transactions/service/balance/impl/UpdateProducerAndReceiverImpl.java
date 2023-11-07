package com.bidi.transactions.service.balance.impl;

import com.bidi.transactions.dto.balance.UpdateProducerAndReceiverBalanceRequest;
import com.bidi.transactions.entity.Balance;
import com.bidi.transactions.repository.BalanceRepository;
import com.bidi.transactions.service.balance.UpdateProducerAndReceiverService;
import com.bidi.transactions.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UpdateProducerAndReceiverImpl implements UpdateProducerAndReceiverService {

    private final BalanceRepository balanceRepository;

    @Override
    public MessageResponse updateProducerAndReceiverBalance(
            UpdateProducerAndReceiverBalanceRequest updateProducerAndReceiverBalanceRequest,
            String idUser) {
        Balance balanceProducer = balanceRepository.findBalanceByPhoneNumber(updateProducerAndReceiverBalanceRequest.getPhoneProducer());
        Balance balanceReceiver = balanceRepository.findBalanceByPhoneNumber(updateProducerAndReceiverBalanceRequest.getPhoneReceiver());

        if (balanceProducer == null) {
            return new MessageResponse("BalanceProducer not exist.");
        }
        if (balanceReceiver == null) {
            return new MessageResponse("BalanceReceiver not exist.");
        }
        if (balanceProducer == balanceReceiver) {
            return new MessageResponse("Invalid Operation.");
        }
        if (balanceProducer.getBalance() < updateProducerAndReceiverBalanceRequest.getAmount()) {
            return new MessageResponse("Balance is not enough");
        }

        balanceProducer = requestToBalanceProducer(balanceProducer, updateProducerAndReceiverBalanceRequest, idUser);
        balanceReceiver = requestToBalanceReceiver(balanceReceiver, updateProducerAndReceiverBalanceRequest);
        balanceRepository.save(balanceProducer);
        balanceRepository.save(balanceReceiver);

        return new MessageResponse("Balance updated successfully.");
    }

    public Balance requestToBalanceProducer(Balance balanceProducer,
                                            UpdateProducerAndReceiverBalanceRequest updateProducerAndReceiverBalanceRequest,
                                            String idUser) {
        balanceProducer.setBalance(subtractBalanceAmount(balanceProducer.getBalance(), updateProducerAndReceiverBalanceRequest.getAmount()));
        balanceProducer.setUpdateDate(LocalDateTime.now());
        balanceProducer.setIdUser(idUser);
        return balanceProducer;
    }

    public Balance requestToBalanceReceiver(Balance balanceReceiver,
                                            UpdateProducerAndReceiverBalanceRequest updateProducerAndReceiverBalanceRequest) {
        balanceReceiver.setBalance(addBalanceAmount(balanceReceiver.getBalance(), updateProducerAndReceiverBalanceRequest.getAmount()));
        balanceReceiver.setUpdateDate(LocalDateTime.now());
        return balanceReceiver;
    }

    public long addBalanceAmount(long currentBalance, long newAmount) {
        return currentBalance + newAmount;
    }

    public long subtractBalanceAmount(long currentBalance, long newAmount) {
        return currentBalance - newAmount;
    }


}
