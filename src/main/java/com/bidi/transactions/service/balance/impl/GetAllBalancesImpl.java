package com.bidi.transactions.service.balance.impl;

import com.bidi.transactions.dto.balance.CreateBalanceResponse;
import com.bidi.transactions.entity.Balance;
import com.bidi.transactions.repository.BalanceRepository;
import com.bidi.transactions.service.balance.GetAllBalancesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllBalancesImpl implements GetAllBalancesService {
    private final BalanceRepository balanceRepository;

    @Override
    public List<CreateBalanceResponse> getAllBalances() {
        List<Balance> balances = balanceRepository.findAll();
        return balanceToResponse(balances);
    }

    public List<CreateBalanceResponse> balanceToResponse(List<Balance> balances) {
        return balances.stream().map(balance -> {
            CreateBalanceResponse response = new CreateBalanceResponse();
            response.setIdBalance(balance.getIdBalance());
            response.setIdUser(balance.getIdUser());
            response.setBalance(balance.getBalance());
            response.setPhoneNumber(balance.getPhoneNumber());
            response.setCreationDate(balance.getCreationDate());
            response.setUpdateDate(balance.getUpdateDate());
            return response;
        }).collect(Collectors.toList());
    }
}
