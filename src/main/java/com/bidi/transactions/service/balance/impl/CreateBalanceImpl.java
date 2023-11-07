package com.bidi.transactions.service.balance.impl;

import com.bidi.transactions.dto.balance.CreateBalanceRequest;

import com.bidi.transactions.entity.Balance;
import com.bidi.transactions.repository.BalanceRepository;
import com.bidi.transactions.service.balance.CreateBalanceService;
import com.bidi.transactions.utils.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateBalanceImpl implements CreateBalanceService {

    private final BalanceRepository balanceRepository;

    @Override
    public MessageResponse createBalance(CreateBalanceRequest createBalanceRequest) {
        Balance balance = balanceRepository.findBalanceByPhoneNumber(createBalanceRequest.getPhoneNumber());
        if(balance != null) {
            return new MessageResponse("Balance Exists.");
        }
        balance = requestToBalance(createBalanceRequest);
        balanceRepository.save(balance);
        return new MessageResponse("Balance created successfully.");
    }

    public Balance requestToBalance(CreateBalanceRequest createBalanceRequest) {
        Balance balance = new Balance();
        balance.setBalance(createBalanceRequest.getBalance());
        balance.setCreationDate(LocalDateTime.now());
        balance.setPhoneNumber(createBalanceRequest.getPhoneNumber());
        return balance;
    }
}
